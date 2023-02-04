package com.example.recipeapp.services.impl;

import com.example.recipeapp.model.Ingredient;
import com.example.recipeapp.model.Recipe;
import com.example.recipeapp.services.FilesService;
import com.example.recipeapp.services.IngredientService;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class IngredientServiceImpl implements IngredientService {
    private static Integer id = 0;
    private static Map<Integer, Ingredient> ingredients = new HashMap<>();
    @Value("${name.of.ingredients.file}")
    public String ingredientsFileName;

    final private FilesService filesService;

    public IngredientServiceImpl (FilesService filesService) {
        this.filesService = filesService;
    }

    @Override
    public Integer addIngredient(Ingredient ingredient) {
        ingredients.put(id, ingredient);
        saveToFile();
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
            saveToFile();
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

    private void saveToFile() {
        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(ingredients);
        } catch (JacksonException e) {
            throw new RuntimeException(e);
        }
        filesService.saveToFile(json,ingredientsFileName);
    }

    private void readFromFile() {
        try {
            String json = filesService.readFromFile(ingredientsFileName);
            ingredients = new ObjectMapper().readValue(json, new TypeReference<Map<Integer, Ingredient>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
