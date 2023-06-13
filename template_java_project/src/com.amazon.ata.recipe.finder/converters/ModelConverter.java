package com.amazon.ata.recipe.finder.converters;

import com.amazon.ata.recipe.finder.dynamodb.models.GroceryList;
import com.amazon.ata.recipe.finder.dynamodb.models.Recipe;
import com.amazon.ata.recipe.finder.models.GroceryListModel;
import com.amazon.ata.recipe.finder.models.RecipeModel;

public class ModelConverter {

    public GroceryListModel toGroceryListModel(GroceryList groceryList) {
        return GroceryListModel.builder()
                .withDate(groceryList.getDate())
                .withItems(groceryList.getItems())
                .build();
    }

    public RecipeModel toRecipeModel(Recipe recipe) {
        return RecipeModel.builder()
                .withName(recipe.getName())
                .withAuthor(recipe.getAuthor())
                .withIngredients(recipe.getIngredients())
                .withInstructionsToUse(recipe.getInstructions())
                .build();
    }
}
