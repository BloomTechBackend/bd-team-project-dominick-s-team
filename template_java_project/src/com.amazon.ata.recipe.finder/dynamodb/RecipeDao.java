package com.amazon.ata.recipe.finder.dynamodb;

import com.amazon.ata.recipe.finder.dynamodb.models.Ingredients;
import com.amazon.ata.recipe.finder.dynamodb.models.Recipe;
import com.amazon.ata.recipe.finder.exceptions.RecipeNotFoundException;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import java.util.List;

public class RecipeDao {
    private final DynamoDBMapper dynamoDBMapper;

    public RecipeDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Recipe getRecipe(List<Ingredients> ingredientsList) {
        Recipe recipe = this.dynamoDBMapper.load(Recipe.class, ingredientsList);

        if(recipe == null) {
            throw new RecipeNotFoundException("No recipe found with given ingredients");
        }
        return recipe;
    }
}
