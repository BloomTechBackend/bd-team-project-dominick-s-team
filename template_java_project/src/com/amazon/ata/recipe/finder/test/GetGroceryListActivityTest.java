package com.amazon.ata.recipe.finder.test;

import com.amazon.ata.recipe.finder.activity.GetGroceryListActivity;
import com.amazon.ata.recipe.finder.dynamodb.GroceryListDao;
import com.amazon.ata.recipe.finder.dynamodb.models.GroceryList;
import com.amazon.ata.recipe.finder.exceptions.GroceryListNotFoundException;
import com.amazon.ata.recipe.finder.models.request.GetGroceryListRequest;
import com.amazon.ata.recipe.finder.models.result.GetGroceryListResult;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GetGroceryListActivityTest {
    private GroceryListDao groceryListDao;
    private GetGroceryListActivity getGroceryListActivity;

    @BeforeEach
    public void setUp() {
        List<String> items = new ArrayList<>();
        items.add("food");
        items.add("water");
        items.add("candy");
        groceryListDao = new GroceryListDao(new DynamoDBMapper(AmazonDynamoDBClientBuilder.standard().withCredentials(DefaultAWSCredentialsProviderChain.getInstance()).withRegion(Regions.US_WEST_2).build()));
        groceryListDao.saveGroceryList(new GroceryList("3/3/3", items));
        getGroceryListActivity = new GetGroceryListActivity(groceryListDao);
    }

    @Test
    public void handleRequest_foundGroceryList_ReturnsGroceryListModel() {
        //GIVEN
        String expectedDate = "3/3/3";
        List<String> expectedItems = new ArrayList<>();
        expectedItems.add("food");
        expectedItems.add("water");
        expectedItems.add("candy");

        GroceryList groceryList = new GroceryList(expectedDate, expectedItems);

        GetGroceryListRequest request = GetGroceryListRequest.builder()
                .withDate(expectedDate)
                .build();

        //WHEN
        GetGroceryListResult result = getGroceryListActivity.handleRequest(request, null);

        //THEN
        Assertions.assertEquals(expectedDate,result.getGroceryList().getDate());
        Assertions.assertEquals(expectedItems, result.getGroceryList().getItems());

    }

    @Test
    public void handleRequest_WrongDate_ThrowsGroceryListNotFoundException() {
       //GIVEN
        String expectedDate = "2/3/3";
        List<String> expectedItems = new ArrayList<>();
        expectedItems.add("food");
        expectedItems.add("water");
        expectedItems.add("candy");
        //WHEN
        GroceryList groceryList = new GroceryList(expectedDate, expectedItems);
        //THEN
        GetGroceryListRequest request = GetGroceryListRequest.builder()
                .withDate(expectedDate)
                .build();



        //THEN + WHEN
        Assertions.assertThrows(GroceryListNotFoundException.class, () -> getGroceryListActivity.handleRequest(request, null));
    }
}
