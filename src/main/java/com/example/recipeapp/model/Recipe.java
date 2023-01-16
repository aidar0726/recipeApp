package com.example.recipeapp.model;

import com.example.recipeapp.model.exceptions.ValidationException;
import com.example.recipeapp.model.validation.Validation;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.example.recipeapp.model.validation.Validation.validateQuantity;

@Data
public class Recipe {
    private String title;
    private Integer cookingTime;
    private List<String> cookingSteps = new LinkedList<>();
    private List<Ingredient> ingredients = new ArrayList<>();

    public Recipe(String title, Integer cookingTime, List<String> cookingSteps, List<Ingredient> ingredients) throws ValidationException {
        this.title = Validation.validateString(title);
        this.cookingTime = validateQuantity(cookingTime);
        this.cookingSteps = cookingSteps;
        this.ingredients = ingredients;
    }

}
