package com.amazon.ata.recipe.finder.models.request;

import com.amazon.ata.recipe.finder.models.GroceryListModel;
import com.amazon.ata.recipe.finder.models.result.GetGroceryListResult;

import java.util.List;
import java.util.Objects;

public class GetGroceryListRequest {

    private String date;


    public GetGroceryListRequest(Builder builder) {this.date = builder.date;}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetGroceryListRequest that)) return false;
        return getDate().equals(that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate());
    }

    @Override
    public String toString() {
        return "GetGroceryListRequest{" +
                "date='" + date + '\'' +
                '}';
    }

    public static Builder builder() {return new Builder();}

    public static final class Builder{
        private String date;

        private Builder() {}

        public Builder withDate(String dateToUse) {
            this.date = dateToUse;
            return this;
        }
        public GetGroceryListRequest build() {return new GetGroceryListRequest(this);}
    }


}
