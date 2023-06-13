package com.amazon.ata.recipe.finder.models;

import java.util.List;
import java.util.Objects;

public class GroceryListModel {
    private String date;
    private List<String> items;

    public GroceryListModel() {}

    public GroceryListModel(Builder builder) {
        this.date = builder.date;
        this.items = builder.items;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroceryListModel that)) return false;
        return getDate().equals(that.getDate()) && getItems().equals(that.getItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getItems());
    }

    public static Builder builder() {return new Builder(); }

    public static final class Builder {
        private String date;
        private List<String> items;

        public Builder withDate(String dateToUse) {
            this.date = dateToUse;
            return this;
        }
        public Builder withItems(List<String> itemsToUse) {
            this.items = itemsToUse;
            return this;
        }



        public GroceryListModel build() {return new GroceryListModel(this); }
    }
}
