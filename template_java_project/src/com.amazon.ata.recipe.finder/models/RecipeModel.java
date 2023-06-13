package com.amazon.ata.recipe.finder.models;

import com.amazon.ata.recipe.finder.dynamodb.models.Ingredients;

import java.util.List;
import java.util.Objects;

public class RecipeModel {
    private String name;
    private String author;
    private List<Ingredients> ingredients;
    private List<String> instructions;

    public RecipeModel() {
    }

    public RecipeModel(Builder builder) {
        this.name = builder.name;
        this.author = builder.author;
        this.ingredients = builder.ingredients;
        this.instructions = builder.instructions;
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

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeModel that)) return false;
        return getName().equals(that.getName()) && getAuthor().equals(that.getAuthor()) && getIngredients().equals(that.getIngredients()) && getInstructions().equals(that.getInstructions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAuthor(), getIngredients(), getInstructions());
    }

    @Override
    public String toString() {
        return "RecipeModel{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", ingredients=" + ingredients +
                ", instructions=" + instructions +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String name;
        private String author;
        private List<Ingredients> ingredients;
        private List<String> instructions;


        public Builder withName(String nameToUse) {
            this.name = nameToUse;
            return this;
        }

        public Builder withAuthor(String authorToUse) {
            this.author = author;
            return this;
        }

        public Builder withIngredients(List<Ingredients> ingredientsToUse) {
            this.ingredients = ingredientsToUse;
            return this;
        }

        public Builder withInstructionsToUse(List<String> instructionsToUse) {
            this.instructions = instructionsToUse;
            return this;
        }

        public RecipeModel build() {return new RecipeModel(this);}
    }
}