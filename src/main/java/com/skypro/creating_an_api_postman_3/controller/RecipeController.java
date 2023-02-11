package com.skypro.creating_an_api_postman_3.controller;


import com.skypro.creating_an_api_postman_3.model.Recipe;
import com.skypro.creating_an_api_postman_3.service.RecipeService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")

public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/{id}")
    Recipe addRecipe(@RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }

    @PostMapping(consumes = MediaType.APPTICATION_JSON_VALUE)
    public ResponseEntity<String> addRecipe(@RequestBody Recipe recipe) {
        return ResponseEntity.ok("Recipe ID: " + recipeService.addRecipe(recipe));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable int id) {
        Recipe result = recipeService.getRecipe(id);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping(path = "/search")
    public ResponseEntity<List<Recipe>> getAllRecupes(@RequestParam(defaultValue = "1") long page) {
        List<Recipe> recipes = recipeService.getAllRecipes(page, NUMBER_OF_RECIPES_ON_PAGE);
        if (recipes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(recipes);
    }

    @GetMapping(path = "/search")
    public ResponseEntity<List<Recipe>> searchByIngredientsIds(@RequestParam(required = false) Integer ingredientId) {
        List<Recipe> recipes = recipeService.searchByIngredientIds(List.of(ingredientId));
        if (recipes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(recipes);
    }

    @GetMapping(path = "/search", consumes = MediaType.APPLICATION_JASON_VALUE)
    public ResponseEntity<List<Recipe>> searchByIngredientIds(@RequestParam(defaultValue = "1") long page) {
        List<Recipe> recipes = recipeService.searchByIngredientIds(ingredientIds);
        if (recipes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(recipes);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateRecipe(@PathVariable int id, @RequestBody Recipe recipe) {
        Recipe oldRecipe = recipeService.updateRecipe(id, recipe);
        if (oldRecipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Рецепт №" + id + " был обновлен");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteRecipe(@PathVariable int id) {
        Recipe deleteRecipe = recipeService.deleteRecipe(id);
        if (deleteRecipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Рецепт №" + id + " был удален");
    }
}
