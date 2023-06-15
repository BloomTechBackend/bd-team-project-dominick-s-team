package com.amazon.ata.recipe.finder.activity;

import com.amazon.ata.recipe.finder.converters.ModelConverter;
import com.amazon.ata.recipe.finder.dynamodb.GroceryListDao;
import com.amazon.ata.recipe.finder.dynamodb.models.GroceryList;
import com.amazon.ata.recipe.finder.exceptions.GroceryListNotFoundException;
import com.amazon.ata.recipe.finder.models.GroceryListModel;
import com.amazon.ata.recipe.finder.models.request.CreateGroceryListRequest;
import com.amazon.ata.recipe.finder.models.result.CreateGroceryListResult;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class CreateGroceryListActivity implements RequestHandler<CreateGroceryListRequest, CreateGroceryListResult> {

    private final Logger log = Logger.getAnonymousLogger();
    private final GroceryListDao groceryListDao;

    public CreateGroceryListActivity(GroceryListDao groceryListDao) {
        this.groceryListDao = groceryListDao;
    }
    public CreateGroceryListActivity() {
        this.groceryListDao = new GroceryListDao(new DynamoDBMapper(AmazonDynamoDBClientBuilder.standard().withCredentials(DefaultAWSCredentialsProviderChain.getInstance()).withRegion(Regions.US_WEST_2).build()));
    }

    @Override
    public CreateGroceryListResult handleRequest(final CreateGroceryListRequest createGroceryListRequest, Context context) {
        log.info("Received CreateGroceryListRequest{}");
        GroceryList groceryList = groceryListDao.getGroceryList(createGroceryListRequest.getDate());
        GroceryList groceryList1 = new GroceryList(createGroceryListRequest.getDate(), createGroceryListRequest.getItems());

        groceryListDao.saveGroceryList(groceryList1);
        GroceryListModel groceryListModel = new ModelConverter().toGroceryListModel(groceryList1);

        return CreateGroceryListResult.builder()
                .withGroceryList(groceryListModel)
                .build();
    }
}
