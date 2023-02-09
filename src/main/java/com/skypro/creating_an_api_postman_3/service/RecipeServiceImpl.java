package com.skypro.creating_an_api_postman_3.service;


import com.skypro.creating_an_api_postman_3.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeServiceImpl {
    private final Map<Integer, Recipe> recipeMap = new HashMap<>();
    private static Integer id = 0;


    @Override
    public Recipe addRecipe(Recipe recipe) {
        recipeMap.put(id++, recipe);
        return recipe;
    }

    @Override
    public Recipe getRecipe(Integer id) {
        if (!recipeMap.getOrDefault(id)) {
            throw new NotFoundException("Рецепт с заданным id не найден");
        }
        return recipeMap.get(id);
    }

    @Override
    public Collection<Recipe> getAll() {
        return recipeMap.values();
    }

    @Override
    public Recipe removeRecipe(int id) {
        if (recipeMap.containsKey(id)) {
            throw new NotFoundException("Рецепт с заданным id не найден")
        }
        @Override
        public Recipe updateRecipe ( int id){
            if (recipeMap.containsKey(id)) {
                throw new NotFoundException("Рецепт с заданным id не найден")
            }
            return recipeMap.put(id, recipe);
        }
    }
