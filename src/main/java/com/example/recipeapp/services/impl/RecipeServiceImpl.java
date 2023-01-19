package com.example.recipeapp.services.impl;

import com.example.recipeapp.model.Recipe;
import com.example.recipeapp.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeServiceImpl implements RecipeService {
    private static Integer id = 0;
    private static Map<Integer, Recipe> recipes = new HashMap<>();

    @Override
    public Integer addRecipe(Recipe recipe) {
        recipes.put(id, recipe);
        return id++;
    }

    @Override
    public Recipe getRecipe(Integer id) {
        if (recipes.containsKey(id)) {
            return recipes.get(id);
        } else {
            throw new NoSuchElementException("Рецепт с данным номером не найден!");
        }
    }

    @Override
    public Recipe editRecipe(Integer id, Recipe recipe) {
        if (recipes.containsKey(id)) {
            recipes.put(id, recipe);
            return recipe;
        } else {
            throw new NoSuchElementException("Рецепт с данным номером не найден!");
        }
    }

    @Override
    public boolean deleteRecipe(Integer id) {
        if (recipes.containsKey(id)) {
            recipes.remove(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Map<Integer, Recipe> getAllRecipe() {
        return recipes;
    }


}
