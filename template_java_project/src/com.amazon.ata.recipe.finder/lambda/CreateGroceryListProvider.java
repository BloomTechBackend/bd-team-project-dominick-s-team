package com.amazon.ata.recipe.finder.lambda;

import com.amazon.ata.recipe.finder.dependency.ServiceComponent;
import com.amazon.ata.recipe.finder.models.request.CreateGroceryListRequest;
import com.amazon.ata.recipe.finder.models.result.CreateGroceryListResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


public class CreateGroceryListProvider  implements RequestHandler<CreateGroceryListRequest, CreateGroceryListResult> {
    private static ServiceComponent serviceComponent;

    public CreateGroceryListProvider() {}

    @Override
    public CreateGroceryListResult handleRequest(final CreateGroceryListRequest createGroceryListRequest, Context context) {
        return serviceComponent.provideCreateGroceryListActivity().handleRequest(createGroceryListRequest, null);
    }

    private ServiceComponent getServiceComponent() {
        return serviceComponent;
    }
}
