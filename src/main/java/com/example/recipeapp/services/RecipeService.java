package com.example.recipeapp.services;

import com.example.recipeapp.model.Recipe;

import java.util.Map;

public interface RecipeService {
    public Integer addRecipe(Recipe recipe);

    Recipe getRecipe(Integer number);

    Map<Integer, Recipe> getRecipeByIngredient(String value);

    Recipe editRecipe(Integer id, Recipe recipe);

    boolean deleteRecipe(Integer id);

    Map<Integer, Recipe> getAllRecipe();
}
