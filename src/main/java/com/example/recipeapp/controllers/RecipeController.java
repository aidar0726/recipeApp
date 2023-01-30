package com.example.recipeapp.controllers;

import com.example.recipeapp.model.Recipe;
import com.example.recipeapp.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public ResponseEntity<Integer> addRecipe(@RequestBody Recipe recipe) {
        Integer id = recipeService.addRecipe(recipe);
        return ResponseEntity.ok().body(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Integer id) {
        Recipe recipe = recipeService.getRecipe(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(recipe);
    }

    @GetMapping("/ingredient/{value}")
    public ResponseEntity<Map<Integer, Recipe>> getRecipeByIngredient(@PathVariable String value) {
        Map<Integer, Recipe> recipes = recipeService.getRecipeByIngredient(value);
        return ResponseEntity.ok(recipes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> editRecipe(@PathVariable Integer id, @RequestBody Recipe recipe) {
        Recipe modifiedRecipe = recipeService.editRecipe(id, recipe);
        if (modifiedRecipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(modifiedRecipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Integer id) {
        if (recipeService.deleteRecipe(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<Map<Integer, Recipe>> getAllRecipe() {
        Map<Integer, Recipe> recipes = recipeService.getAllRecipe();
        return ResponseEntity.ok(recipes);
    }
}
