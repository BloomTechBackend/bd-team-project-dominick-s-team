package com.amazon.ata.recipe.finder.activity;

import com.amazon.ata.recipe.finder.converters.ModelConverter;
import com.amazon.ata.recipe.finder.dynamodb.GroceryListDao;
import com.amazon.ata.recipe.finder.dynamodb.models.GroceryList;
import com.amazon.ata.recipe.finder.exceptions.GroceryListNotFoundException;
import com.amazon.ata.recipe.finder.models.GroceryListModel;
import com.amazon.ata.recipe.finder.models.request.GetGroceryListRequest;
import com.amazon.ata.recipe.finder.models.result.GetGroceryListResult;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import javax.inject.Inject;
import java.util.logging.Logger;

public class GetGroceryListActivity implements RequestHandler<GetGroceryListRequest, GetGroceryListResult> {

    private final Logger log = Logger.getAnonymousLogger();
    private final GroceryListDao groceryListDao;

    @Inject
    public GetGroceryListActivity(GroceryListDao groceryListDao) { this.groceryListDao = groceryListDao;}

    public GetGroceryListActivity() {
         this.groceryListDao = new GroceryListDao(new DynamoDBMapper(AmazonDynamoDBClientBuilder.standard().withCredentials(DefaultAWSCredentialsProviderChain.getInstance()).withRegion(Regions.US_WEST_2).build()));
    }


    @Override
    public GetGroceryListResult handleRequest(final GetGroceryListRequest getGroceryListRequest, Context context) {
         log.info("Recieved request to retrieve grocery list{}");
         String groceryList = getGroceryListRequest.getDate();
         if((groceryListDao.getGroceryList(groceryList) == null)) {
                throw new GroceryListNotFoundException("No grocery list found with given date: " + getGroceryListRequest.getDate());
         }
         GroceryList list = groceryListDao.getGroceryList(groceryList);
         GroceryListModel groceryListModel = new ModelConverter().toGroceryListModel(list);
         return GetGroceryListResult.builder().withGroceryList(groceryListModel).build();
         }
}
