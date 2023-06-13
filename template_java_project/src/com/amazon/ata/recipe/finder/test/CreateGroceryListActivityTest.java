package com.amazon.ata.recipe.finder.test;

import com.amazon.ata.recipe.finder.activity.CreateGroceryListActivity;
import com.amazon.ata.recipe.finder.dynamodb.GroceryListDao;
import com.amazon.ata.recipe.finder.dynamodb.models.GroceryList;
import com.amazon.ata.recipe.finder.models.GroceryListModel;
import com.amazon.ata.recipe.finder.models.request.CreateGroceryListRequest;
import com.amazon.ata.recipe.finder.models.result.CreateGroceryListResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.ArrayList;
import java.util.List;

public class CreateGroceryListActivityTest {

    private GroceryListDao groceryList;

    private CreateGroceryListActivity createGroceryListActivity;

    @BeforeEach
    public void setup() {
        List<String> items = new ArrayList<>();
        items.add("butter");
        items.add("milk");
        items.add("anchovies");
        groceryList.saveGroceryList(new GroceryList("12/25/2024", items));
        createGroceryListActivity = new CreateGroceryListActivity(groceryList);

    }

    @Test
    public void handleRequest_validDate_CreatesGroceryList() {
        //GIVEN
        String date = "12/25/2024";
        List<String> items = new ArrayList<>();
        items.add("butter");
        items.add("milk");
        items.add("anchovies");



        CreateGroceryListRequest request = CreateGroceryListRequest.builder()
                .withDate(date)
                .withItems(items)
                .build();

        //WHEN
        CreateGroceryListResult result = (createGroceryListActivity.handleRequest(request, null));
        //THEN
        Assertions.assertEquals(request.getDate(), result.getGroceryList().getDate());
    }
}
