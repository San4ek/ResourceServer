package com.example.demoapi.controllers;

import com.example.demoapi.annotations.Rest;
import com.example.demoapi.models.Ingredient;
import com.example.demoapi.services.IngredientService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Rest(path = "/api/ingredients")
public class IngredientRestController {

    private final IngredientService service;

    public IngredientRestController(IngredientService service) {
        this.service=service;
    }

    public @ResponseBody Page<Iterable<Ingredient>> getAll(Pageable pageable) {
        return service.getAll(pageable);
    }

    @GetMapping("/{id}")
    public @ResponseBody Ingredient get(@PathVariable String id) {
        return service.findOrThrow(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Ingredient save(@RequestBody @Valid Ingredient ingredient) {
            return service.save(ingredient);
    }

    @DeleteMapping
    public void deleteAllByIds(@RequestParam
                           @NotEmpty(message = "Should be at least 1 element")
                           List<String> ids) {
        service.deleteAllByIds(ids);
    }
}
