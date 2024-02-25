package com.example.demoapi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min=5, message = "Name must be at least 5 characters long")
    public String name;

    @NotNull
    @ManyToMany
    @Size(min=3, message = "You must choose at least 3 ingredients")
    private List<Ingredient> ingredients;

    @ManyToMany
    private List<TacoOrder> tacoOrder;

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
}
