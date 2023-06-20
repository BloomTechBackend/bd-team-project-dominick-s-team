package com.amazon.ata.recipe.finder.activity;

import com.amazon.ata.recipe.finder.converters.ModelConverter;
import com.amazon.ata.recipe.finder.dynamodb.RecipeDao;
import com.amazon.ata.recipe.finder.dynamodb.models.Recipe;
import com.amazon.ata.recipe.finder.exceptions.RecipeNotFoundException;
import com.amazon.ata.recipe.finder.models.RecipeModel;
import com.amazon.ata.recipe.finder.models.request.GetRecipeRequest;
import com.amazon.ata.recipe.finder.models.result.GetGroceryListResult;
import com.amazon.ata.recipe.finder.models.result.GetRecipeResult;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import javax.inject.Inject;
import java.util.logging.Logger;

public class GetRecipeActivity implements RequestHandler<GetRecipeRequest, GetRecipeResult> {
    private final Logger log = Logger.getAnonymousLogger();
    private RecipeDao recipeDao;

    @Inject
    public GetRecipeActivity(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }
    public GetRecipeActivity(){
        this.recipeDao = new RecipeDao(new DynamoDBMapper(AmazonDynamoDBClientBuilder.standard().withCredentials(DefaultAWSCredentialsProviderChain.getInstance()).withRegion(Regions.US_WEST_2).build()));
    }

    @Override
    public GetRecipeResult handleRequest(GetRecipeRequest recipeRequest, Context context) {
        log.info("revieved request to retrieve recipe with given name: " + recipeRequest);
        String recipeName = recipeRequest.getName();

        if(recipeDao.getRecipe(recipeName) == null) {
            throw new RecipeNotFoundException("No recipe found with given name: " + recipeName);
        }
        Recipe recipe = recipeDao.getRecipe(recipeName);
        RecipeModel recipeModel = new ModelConverter().toRecipeModel(recipe);
        return GetRecipeResult.builder().withRecipe(recipeModel).build();
    }
}
