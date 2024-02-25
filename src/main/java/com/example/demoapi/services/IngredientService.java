package com.example.demoapi.services;

import com.example.demoapi.exceptions.NoAnyContentException;
import com.example.demoapi.exceptions.NotFoundException;
import com.example.demoapi.models.Ingredient;
import com.example.demoapi.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    private final IngredientRepository repository;

    @Autowired
    public IngredientService(IngredientRepository repository) {
        this.repository=repository;
    }

    public Page<Iterable<Ingredient>> getAll(Pageable pageable) {
        Page<Iterable<Ingredient>> ingredientsPage=repository.findAll(pageable);
        if (ingredientsPage.iterator().hasNext()) {
            return ingredientsPage;
        } else {
            throw new NoAnyContentException();
        }
    }

    public Ingredient findOrThrow(String id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Ingredient not found"));
    }

    public Ingredient save(Ingredient ingredient) {
        return repository.save(ingredient);
    }

    public void deleteAllByIds(List<String> ids) {
        repository.deleteAllByIdIn(ids);
    }
}
