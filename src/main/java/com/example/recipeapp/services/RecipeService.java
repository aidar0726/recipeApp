package com.example.recipeapp.services;

import com.example.recipeapp.model.Recipe;

public interface RecipeService {
    public void recipeAdd (Recipe recipe);

    Recipe getRecipe(Integer number);
}
