package com.example.demoapi.converters;

import com.example.demoapi.models.Ingredient;
import com.example.demoapi.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private final Map<String,Ingredient> ingredientMap=new HashMap<>();

    @Autowired
    public IngredientByIdConverter(IngredientRepository repo) {
        Iterable<Ingredient> ingredients= repo.findAll();

        for (Ingredient ingredient : ingredients) {
            ingredientMap.put(ingredient.getId(), ingredient);
        }
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }
}
