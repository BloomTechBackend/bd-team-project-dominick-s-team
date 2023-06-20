package com.amazon.ata.recipe.finder.models.request;

import java.util.List;
import java.util.Objects;

public class GetRecipeRequest {
    private String name;
    private String author;

    public GetRecipeRequest(){};

    public  GetRecipeRequest(Builder builder) {
        this.name = builder.name;
        this.author = builder.author;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetRecipeRequest that)) return false;
        return getName().equals(that.getName()) && getAuthor().equals(that.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAuthor());
    }

    @Override
    public String toString() {
        return "GetRecipeRequest{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public static Builder builder() {return new Builder();}

    public static final class Builder {
        private String name;
        private String author;
        private Builder () {}

        public Builder withName(String nameToUse) {
            this.name = nameToUse;
            return this;
        }
        public Builder withAuthor(String authorToUse) {
            this.author = authorToUse;
            return this;
        }


        public GetRecipeRequest build() { return new GetRecipeRequest(this);}
    }
}
