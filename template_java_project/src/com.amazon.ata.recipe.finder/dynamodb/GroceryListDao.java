package com.amazon.ata.recipe.finder.dynamodb;


import com.amazon.ata.recipe.finder.dynamodb.models.GroceryList;
import com.amazon.ata.recipe.finder.exceptions.GroceryListNotFoundException;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import javax.inject.Inject;

public class GroceryListDao {
    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public GroceryListDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public GroceryList getGroceryList(String date) {
        GroceryList groceryList = this.dynamoDBMapper.load(GroceryList.class, date);

        if(groceryList == null) {
            throw new GroceryListNotFoundException("Grocery list with given date not found");
        }
        return groceryList;
    }

    public GroceryList saveGroceryList(GroceryList groceryList) {
        dynamoDBMapper.save(groceryList);
        GroceryList groceryList1 = new GroceryList(groceryList.getDate(), groceryList.getItems());
        groceryList1.setDate(groceryList.getDate());
        groceryList1.setItems(groceryList.getItems());
        return groceryList1;
    }
}
