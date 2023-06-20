package com.amazon.ata.recipe.finder.lambda;

import com.amazon.ata.recipe.finder.dependency.ServiceComponent;
import com.amazon.ata.recipe.finder.models.request.GetRecipeRequest;
import com.amazon.ata.recipe.finder.models.result.GetRecipeResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GetRecipeProvider implements RequestHandler<GetRecipeRequest, GetRecipeResult> {
    private static ServiceComponent serviceComponent;

    @Override
    public GetRecipeResult handleRequest(final GetRecipeRequest getRecipeRequest, Context context) {
        return serviceComponent.provideGetRecipeActivity().handleRequest(getRecipeRequest, null);
    }

    public static ServiceComponent getServiceComponent() {
        return serviceComponent;
    }
}
