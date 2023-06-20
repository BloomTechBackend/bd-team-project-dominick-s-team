package com.amazon.ata.recipe.finder.dynamodb;

import com.amazon.ata.recipe.finder.dynamodb.models.Ingredients;
import com.amazon.ata.recipe.finder.dynamodb.models.Recipe;
import com.amazon.ata.recipe.finder.exceptions.RecipeNotFoundException;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import javax.inject.Inject;
import java.util.List;

public class RecipeDao {
    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public RecipeDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Recipe getRecipe(String name) {
        Recipe recipe = this.dynamoDBMapper.load(Recipe.class, name);

        if(recipe == null) {
            throw new RecipeNotFoundException("No recipe found with given ingredients");
        }
        return recipe;
    }
    public Recipe saveRecipe(Recipe recipe) {
        dynamoDBMapper.save(recipe);
        Recipe recipe1 = new Recipe(recipe.getName(),recipe.getAuthor(), recipe.getIngredients(),recipe.getInstructions());
        recipe1.setName(recipe.getName());
        recipe1.setAuthor(recipe.getAuthor());
        recipe1.setIngredients(recipe.getIngredients());
        recipe1.setInstructions(recipe.getInstructions());
        return recipe1;
    }
}
