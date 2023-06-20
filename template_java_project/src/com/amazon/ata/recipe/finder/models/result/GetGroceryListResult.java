package com.amazon.ata.recipe.finder.models.result;

import com.amazon.ata.recipe.finder.models.GroceryListModel;

public class GetGroceryListResult {
    private GroceryListModel groceryList;

    public GetGroceryListResult(Builder builder) {
        this.groceryList = builder.groceryList;
    }
    public GroceryListModel getGroceryList() {
        return groceryList;
    }

    public void setGroceryList(GroceryListModel groceryList) {
        this.groceryList = groceryList;
    }
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private GroceryListModel groceryList;

        public Builder withGroceryList(GroceryListModel groceryListToUse) {
            this.groceryList = groceryListToUse;
            return this;
        }
        public GetGroceryListResult build() {
            return new GetGroceryListResult(this);
        }
    }
}
