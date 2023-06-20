package com.amazon.ata.recipe.finder.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Collections;
import java.util.List;

@DynamoDBTable(tableName = "GroceryList")
public class GroceryList {
    private String date;
    private List<String> items;

    public GroceryList(){}
    public GroceryList (String date, List<String> items){
        this.date = date;
        this.items = items;
    }

    @DynamoDBHashKey(attributeName = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public List<String> getItems() {
        if(this.items == null){
            return  Collections.emptyList();
        }
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}

