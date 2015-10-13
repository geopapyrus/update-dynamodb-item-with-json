# update-dynamodb-item-with-json
Update an existing item's attributes in DynamoDB from a json map of attributes/values

Even though DynamoDB supports Item creation from json, it lacks the same functionality for updates.

This snippet creates the proper input for UpdateItemSpec in order to submit an updateItem request from a set of attribute/values in a map.

Assumes primary key is named id.
