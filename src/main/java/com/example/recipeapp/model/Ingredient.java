package com.example.recipeapp.model;

import com.example.recipeapp.model.exceptions.ValidationException;

import static com.example.recipeapp.model.validation.Validation.validateQuantity;
import static com.example.recipeapp.model.validation.Validation.validateString;
import lombok.Data;

@Data
public class Ingredient {
private String titleIngredient;
private Integer quantity;
private String unit;

    public Ingredient(String titleIngredient, Integer quantity, String unit) throws ValidationException{
        this.titleIngredient = validateString(titleIngredient);
        this.quantity = validateQuantity(quantity);
        this.unit = validateString(unit);
    }

}
