package com.example.recipeapp.services.impl;

import com.example.recipeapp.model.Ingredient;
import com.example.recipeapp.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class IngredientServiceImpl implements IngredientService {
    private static Integer id = 0;
    private static Map<Integer, Ingredient> ingredients = new HashMap<>();

    @Override
    public Integer addIngredient(Ingredient ingredient) {
        ingredients.put(id, ingredient);
        return id++;
    }

    @Override
    public Ingredient getIngredient(Integer id) {
        if (ingredients.containsKey(id)) {
            return ingredients.get(id);
        } else {
            throw new NoSuchElementException("Ингредиент с данным номером не найден!");
        }
    }

    @Override
    public Ingredient editIngredient(Integer id, Ingredient ingredient) {
        if (ingredients.containsKey(id)) {
            ingredients.put(id, ingredient);
            return ingredient;
        } else {
            throw new NoSuchElementException("Ингредиент с данным номером не найден!");
        }
    }

    @Override
    public boolean deleteIngredient(Integer id) {
        if (ingredients.containsKey(id)) {
            ingredients.remove(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Map<Integer, Ingredient> getAllIngredient() {
        return ingredients;
    }

}
