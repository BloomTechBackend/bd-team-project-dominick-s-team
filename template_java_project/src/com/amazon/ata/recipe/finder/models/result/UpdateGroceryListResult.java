package com.amazon.ata.recipe.finder.models.result;

import com.amazon.ata.recipe.finder.models.GroceryListModel;

public class UpdateGroceryListResult {
    private GroceryListModel groceryList;

    public UpdateGroceryListResult(Builder builder) {
        this.groceryList = builder.groceryList;
    }
    public GroceryListModel getGroceryList() {
        return groceryList;
    }

    public void setGroceryList(GroceryListModel groceryList) {
        this.groceryList = groceryList;
    }
    public Builder build() {
        return new Builder();
    }

    public static final class Builder {
        private GroceryListModel groceryList;

        public Builder build(GroceryListModel groceryListToUse) {
            this.groceryList = groceryListToUse;
            return this;
        }
        public UpdateGroceryListResult build() {
            return new UpdateGroceryListResult(this);
        }
    }
}
