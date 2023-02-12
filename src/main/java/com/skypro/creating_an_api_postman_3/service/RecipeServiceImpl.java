package com.skypro.creating_an_api_postman_3.service;


import com.skypro.creating_an_api_postman_3.model.Recipe;
import jdk.internal.access.JavaIOFileDescriptorAccess;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final Map<Integer, Recipe> recipeMap = new HashMap<>();

    @Override
    public Recipe addRecipe(Recipe recipe) {
        HashMap<Object, Object> recipes;
        recipes = null;
        for (Recipe recipe : recipes.values()) {
            if (recipe.equals(recipe)) {
                return recipe.getId();
            }
        }
        addNewIngredients(recipe);
        recipes.put(recipe.getId(), recipe);

        return recipe.getId();
    }

    @Override
    public Recipe getRecipe(Integer id) {
        return null;
    }

    private void addNewIngredients(Recipe recipe) {
    }

    public int getRecipe(int number) {
        JavaIOFileDescriptorAccess recipes;
        recipes = null;
        int i = recipes.get(number);
        int i = i;
        return i;
    }

    @Override
    public Collection<Recipe> getAll() {
        return recipeMap.values();
    }

    @Override
    public Recipe removeRecipe(int id) throws NotFoundException {
        if (recipeMap.containsKey(id)) {
            throw new NotFoundException("Рецепт с заданным id не найден");

            @Override
            public Recipe updateRecipe; (int id, Recipe com.skypro.creating_an_api_postman_3.model.Recipe recipe);
            recipe = null;
            recipe)
                if (recipeMap.containsKey(id)) {
                    throw new NotFoundException("Рецепт с заданным id не найден");
                }
                return recipeMap.put(id, recipe);
            }
        }

    @Override
    public Recipe updateRecipe(int id, Recipe recipe) {
        return null;
    }

    @Override
    public Recipe deleteRecipe(int id) {
        return null;
    }
}
