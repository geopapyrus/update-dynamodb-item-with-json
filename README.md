# Update dynamodb item with json
Update an existing item's attributes in DynamoDB from a json map of attributes/values

Even though DynamoDB supports Item creation from json, it lacks the same functionality for updates.
Although you could submit a putitem request from json for an existing item, it would replace the entire old item, setting missing attributes to null instead of only updating the desired attributes.

This snippet creates the proper input for UpdateItemSpec in order to submit an updateItem request from a set of attribute/values in a map.

Assumes primary key is named id.
