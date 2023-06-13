package com.amazon.ata.recipe.finder.exceptions;

public class GroceryListNotFoundException extends RuntimeException {
    private static long serialVersionUID= 4001681538317224946L;

    public GroceryListNotFoundException() {
        super();
    }
    public GroceryListNotFoundException(String message) {
        super(message);
    }
    public GroceryListNotFoundException(Throwable cause) {
        super(cause);
    }
    public GroceryListNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
