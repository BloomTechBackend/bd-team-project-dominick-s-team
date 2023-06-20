package com.amazon.ata.recipe.finder.test;

import com.amazon.ata.recipe.finder.activity.GetRecipeActivity;
import com.amazon.ata.recipe.finder.dynamodb.RecipeDao;
import com.amazon.ata.recipe.finder.dynamodb.models.Recipe;
import com.amazon.ata.recipe.finder.exceptions.RecipeNotFoundException;
import com.amazon.ata.recipe.finder.models.request.GetRecipeRequest;
import com.amazon.ata.recipe.finder.models.result.GetRecipeResult;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GetRecipeTest {

    private RecipeDao recipeDao;

    private GetRecipeActivity getRecipeActivity;

    @BeforeEach
    public void setUp() {
        List<String> instructions = new ArrayList<>();
        instructions.add("cook");
        instructions.add("boil");
        instructions.add("eat");
        List<String> ingredients = new ArrayList<>();
        ingredients.add("noodles");
        ingredients.add("meat");
        ingredients.add("sauce");
        recipeDao = new RecipeDao(new DynamoDBMapper(AmazonDynamoDBClientBuilder.standard().withCredentials(DefaultAWSCredentialsProviderChain.getInstance()).withRegion(Regions.US_WEST_2).build()));
        recipeDao.saveRecipe(new Recipe("tacos", "tommy", ingredients, instructions));
        getRecipeActivity = new GetRecipeActivity(recipeDao);
    }

    @Test
    public void handleRequest_WithGoodRecipeName_ReturnsRecipe(){
        //THEN
        String expectedName = "tacos";
        String expectedAuthor = "tommy";
        List<String> expectedInstructions = new ArrayList<>();
        expectedInstructions.add("cook");
        expectedInstructions.add("boil");
        expectedInstructions.add("eat");
        List<String> expectedIngredients = new ArrayList<>();
        expectedIngredients.add("noodles");
        expectedIngredients.add("meat");
        expectedIngredients.add("sauce");
        //WHEN
        Recipe recipe = new Recipe(expectedName,expectedAuthor, expectedInstructions, expectedIngredients);

        GetRecipeRequest recipeRequest = GetRecipeRequest.builder()
                .withName(expectedName)
                .withAuthor(expectedAuthor)
                .build();

        GetRecipeResult result = getRecipeActivity.handleRequest(recipeRequest, null);
        //THEN
        Assertions.assertEquals(expectedName, result.getRecipe().getName());
        Assertions.assertEquals(expectedIngredients, result.getRecipe().getIngredients());
        Assertions.assertEquals(expectedInstructions, result.getRecipe().getInstructions());

        System.out.println(result.getRecipe().getIngredients());
    }
    @Test
    public void handleRequest_BadName_throwsException() {
       //GIVEN
        String expectedName = "taco";
        String expectedAuthor = "tommy";
        List<String> expectedInstructions = new ArrayList<>();
        expectedInstructions.add("cook");
        expectedInstructions.add("boil");
        expectedInstructions.add("eat");
        List<String> expectedIngredients = new ArrayList<>();
        expectedIngredients.add("noodles");
        expectedIngredients.add("meat");
        expectedIngredients.add("sauce");

        Recipe recipe = new Recipe(expectedName,expectedAuthor, expectedInstructions, expectedIngredients);

        GetRecipeRequest recipeRequest = GetRecipeRequest.builder()
                .withName(expectedName)
                .withAuthor(expectedAuthor)
                .build();
        //WHEN + THEN
        Assertions.assertThrows(RecipeNotFoundException.class, () -> getRecipeActivity.handleRequest(recipeRequest, null));
    }
    }
