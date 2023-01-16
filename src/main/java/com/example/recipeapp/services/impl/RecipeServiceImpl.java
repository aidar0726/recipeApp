package com.example.recipeapp.services.impl;

import com.example.recipeapp.model.Recipe;
import com.example.recipeapp.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecipeServiceImpl implements RecipeService {
    private static Integer id = 0;
    private static Map<Integer, Recipe> recipes = new HashMap<>();

    @Override
    public void recipeAdd(Recipe recipe) {
        recipes.put(id++, recipe);
    }

    @Override
    public Recipe getRecipe(Integer number) {
        if(recipes.containsKey(number)) {
           return recipes.get(number);
        } else {
            return null;
        }
    }
}
