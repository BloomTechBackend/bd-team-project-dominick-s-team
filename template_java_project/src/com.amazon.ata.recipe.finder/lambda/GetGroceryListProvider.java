package com.amazon.ata.recipe.finder.lambda;

import com.amazon.ata.recipe.finder.dependency.ServiceComponent;
import com.amazon.ata.recipe.finder.models.request.GetGroceryListRequest;
import com.amazon.ata.recipe.finder.models.result.GetGroceryListResult;
import com.amazonaws.Request;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GetGroceryListProvider implements RequestHandler<GetGroceryListRequest, GetGroceryListResult> {
    private static ServiceComponent serviceComponent;

    public GetGroceryListResult handleRequest(final GetGroceryListRequest getGroceryListRequest, Context context) {
        return serviceComponent.provideGetGroceryListActivity().handleRequest(getGroceryListRequest, context);
    }
    public static ServiceComponent getServiceComponent() {
        return serviceComponent;
    }
}
