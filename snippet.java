
    //generate nameMap, valueMap and updateExpression from json map

    HashMap<String, String> nameMap = new HashMap<String, String>();
    HashMap<String, Object> valueMap = new HashMap<String, Object>();

    Iterator it = userAttributes.entrySet().iterator();
    int i=0;
    String expression="set ";
    while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        if(pair.getKey() != "id") {

            expression=expression+"#attritubeName"+i+" = :val"+i;
            nameMap.put("#attritubeName"+i, (String)pair.getKey()); 
            valueMap.put(":val"+i, pair.getValue());

            if(it.hasNext()) expression=expression+",";

            it.remove();
            i++;
        }
    }

    try {
        //submit update request
        Table table = client.getTable("User");

        UpdateItemSpec updateItemSpec = new UpdateItemSpec()
        .withPrimaryKey("id", userAttributes.get("id"))
        .withUpdateExpression(expression)
        .withNameMap(nameMap)
        .withValueMap(valueMap)
        .withReturnValues(ReturnValue.ALL_NEW);

        UpdateItemOutcome outcome =  table.updateItem(updateItemSpec);

        System.out.println("Updated attributes: "+outcome.getItem().toJSON());
    }
    catch(AmazonServiceException ase) {
        ase.printStackTrace();
        ase.getMessage();
    }
    catch (Exception e) {
        e.printStackTrace();
        e.getMessage();
    }
