package com.amazon.ata.recipe.finder.exceptions;

public class RecipeNotFoundException extends RuntimeException{
    public static  long serialVersionUID = 5092142369582231670L;

    public RecipeNotFoundException() {
        super();
    }

    public RecipeNotFoundException(String message) {
        super(message);
    }

    public RecipeNotFoundException(Throwable cause) {
        super(cause);
    }

    public RecipeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
