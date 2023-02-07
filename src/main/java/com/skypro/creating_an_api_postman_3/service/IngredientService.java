package com.skypro.creating_an_api_postman_3.service;


import com.skypro.creating_an_api_postman_3.model.Ingredient;

import java.util.Collection;

public interface IngredientService {
    Ingredient addIngredient(Ingredient ingredient);

    Ingredient getIngredient(Integer id);

    Collection<Ingredient> getAll();

    Ingredient removeIngredient(int id);

    Ingredient updateIngredient(int id, Ingredient ingredient);

}
