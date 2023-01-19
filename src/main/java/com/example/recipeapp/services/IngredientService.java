package com.example.recipeapp.services;

import com.example.recipeapp.model.Ingredient;
import com.example.recipeapp.model.Recipe;

import java.util.Map;

public interface IngredientService {
    public Integer addIngredient(Ingredient ingredient);

    Ingredient getIngredient(Integer number);

    Ingredient editIngredient(Integer id, Ingredient ingredient);

    boolean deleteIngredient(Integer id);

    Map<Integer, Ingredient> getAllIngredient();
}
