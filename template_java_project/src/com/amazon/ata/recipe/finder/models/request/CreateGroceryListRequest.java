package com.amazon.ata.recipe.finder.models.request;

import java.util.List;
import java.util.Objects;

public class CreateGroceryListRequest {
    private String date;
    private List<String> items;

    public CreateGroceryListRequest(String date, List<String> items) {
        this.date = date;
        this.items = items;
    }
    public CreateGroceryListRequest() {}

    public CreateGroceryListRequest(Builder builder) {
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
        if (!(o instanceof CreateGroceryListRequest that)) return false;
        return getDate().equals(that.getDate()) && getItems().equals(that.getItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getItems());
    }

    @Override
    public String toString() {
        return "CreateGroceryListRequest{" +
                "date='" + date + '\'' +
                ", items=" + items +
                '}';
    }

    public static Builder builder() { return new Builder();}

    public static final class Builder {
        private String date;
        private List<String> items;

        private Builder () {}

        public Builder withDate(String dateToUse) {
            this.date = dateToUse;
            return this;
        }
        public Builder withItems(List<String> itemsToUse) {
            this.items = itemsToUse;
            return this;
        }
        public CreateGroceryListRequest build() {
            return new CreateGroceryListRequest(this);
        }
    }
}
