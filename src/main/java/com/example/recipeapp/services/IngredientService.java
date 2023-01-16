package com.example.recipeapp.services;

import com.example.recipeapp.model.Ingredient;
import com.example.recipeapp.model.Recipe;

public interface IngredientService {
    public void ingredientAdd (Ingredient ingredient);

    Ingredient getIngredient(Integer number);
}
