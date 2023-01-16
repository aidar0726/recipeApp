package com.example.recipeapp.services.impl;

import com.example.recipeapp.model.Ingredient;
import com.example.recipeapp.model.Recipe;
import com.example.recipeapp.services.IngredientService;

import java.util.HashMap;
import java.util.Map;

public class IngredientServiceImpl implements IngredientService {
    private static Integer id = 0;
    private static Map<Integer, Ingredient> ingredients = new HashMap<>();

    @Override
    public void ingredientAdd(Ingredient ingredient) {
        ingredients.put(id++, ingredient);
    }

    @Override
    public Ingredient getIngredient(Integer number) {
        if (ingredients.containsKey(number)) {
            return ingredients.get(number);
        } else {
            return null;
        }
    }
}
