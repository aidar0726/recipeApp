package com.example.recipeapp.controllers;

import com.example.recipeapp.model.Ingredient;
import com.example.recipeapp.model.Recipe;
import com.example.recipeapp.services.IngredientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ingredient")
@Tag(name = "Ингредиенты",description = "CRUD-операции для работы с ингредиентами")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    @Operation(
            summary = "Добавляет ингредиент"
    )
    public ResponseEntity<Integer> addIngredient(@RequestBody Ingredient ingredient) {
        Integer id = ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok().body(id);
    }

    @GetMapping("/{id}")
    @Operation (
            summary = "Находит ингредиент по id"
    )
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable Integer id) {
        Ingredient ingredient = ingredientService.getIngredient(id);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(ingredient);
    }

    @PutMapping("/{id}")
    @Operation (
            summary = "Редактирует ингредиент по id"
    )
    public ResponseEntity<Ingredient> editIngredient(@PathVariable Integer id, @RequestBody Ingredient ingredient) {
        Ingredient modifiedIngredient = ingredientService.editIngredient(id, ingredient);
        if (modifiedIngredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(modifiedIngredient);
    }

    @DeleteMapping("/{id}")
    @Operation (
            summary = "Удаляет ингредиент"
    )
    public ResponseEntity<Void> deleteIngredient(@PathVariable Integer id) {
        if (ingredientService.deleteIngredient(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    @Operation (
            summary = "Показывает все ингредиенты"
    )
    public ResponseEntity<Map<Integer, Ingredient>> getAllIngredient() {
        Map<Integer, Ingredient> ingredients = ingredientService.getAllIngredient();
        return ResponseEntity.ok(ingredients);
    }
}
