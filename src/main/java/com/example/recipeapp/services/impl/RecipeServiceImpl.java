package com.example.recipeapp.services.impl;

import com.example.recipeapp.model.Ingredient;
import com.example.recipeapp.model.Recipe;
import com.example.recipeapp.services.FilesService;
import com.example.recipeapp.services.RecipeService;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class RecipeServiceImpl implements RecipeService {
    private static Integer id = 0;
    @Value("${name.of.recipes.file}")

    public String recipesFileName;

    final private FilesService filesService;
    private static Map<Integer, Recipe> recipes = new HashMap<>();

    public RecipeServiceImpl (FilesService filesService) {
        this.filesService = filesService;
    }


    @Override
    public Integer addRecipe(Recipe recipe) {
        recipes.put(id, recipe);
        saveToFile();
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
    public Map<Integer, Recipe> getRecipeByIngredient(String value) {
        Map<Integer, Recipe> newRecipes = new HashMap<>();
        for (Map.Entry<Integer, Recipe> recipes: recipes.entrySet())
        {
            for(Ingredient ingredient : recipes.getValue().getIngredients()) {
                if(ingredient.getTitleIngredient().equals(value)) {
                    newRecipes.put(recipes.getKey(),recipes.getValue());
                }
            }
        }

        return newRecipes;
    }

    @Override
    public Recipe editRecipe(Integer id, Recipe recipe) {
        if (recipes.containsKey(id)) {
            recipes.put(id, recipe);
            saveToFile();
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

    @PostConstruct
    private void init(){
        filesService.readFromFile(recipesFileName);
    }

    private void saveToFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(recipes);
            filesService.saveToFile(json,recipesFileName);
        } catch (JacksonException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFromFile() {
        try {
            String json = filesService.readFromFile(recipesFileName);
            recipes = new ObjectMapper().readValue(json, new TypeReference<Map<Integer,Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
