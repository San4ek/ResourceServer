package com.example.demoapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class Ingredient implements Serializable {

    @Id
    @NotBlank(message = "Must not be blank")
    @Size(min = 4)
    private final String id;

    @NotBlank(message = "Must not be blank")
    @Size(min = 4, message = "Must be at least 4 characters")
    private final String name;

    @NotNull(message = "Must not be blank")
    private final Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
