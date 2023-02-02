package com.example.recipeapp.model;

import com.example.recipeapp.model.exceptions.ValidationException;
import com.example.recipeapp.model.validation.Validation;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

import static com.example.recipeapp.model.validation.Validation.validateQuantity;

@Data
public class Recipe {
    private String title;
    private Integer cookingTime;
    private List<String> steps = new ArrayList<>();
    private List<Ingredient> ingredients = new ArrayList<>();

    public Recipe(String title, Integer cookingTime, List<Ingredient> ingredients, ArrayList<String> steps) throws ValidationException {
        this.title = Validation.validateString(title);
        this.cookingTime = validateQuantity(cookingTime);
        this.steps = steps;
        this.ingredients = ingredients;
    }

}
