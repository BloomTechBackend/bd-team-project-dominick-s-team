package com.amazon.ata.recipe.finder.dynamodb.models;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.List;

@DynamoDBTable(tableName = "Recipe")
public class Recipe {
    private String name;
    private String author;
    private List<String> ingredients;
    private List<String> instructions;

    public Recipe(){}
    public Recipe(String name, String author, List<String> ingredients, List<String> instructions) {
        this.name = name;
        this.author = author;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    @DynamoDBHashKey(attributeName = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }
}
