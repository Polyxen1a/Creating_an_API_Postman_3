package com.skypro.creating_an_api_postman_3.service;


import com.skypro.creating_an_api_postman_3.model.Recipe;

import java.util.Collection;

public interface RecipeService {
    Recipe addRecipe(Recipe recipe);

    Recipe getRecipe(Integer id);

    Collection<Recipe> getAll();

    Recipe removeRecipe(int id);

    Recipe updateRecipe(int id, Recipe recipe);

}
