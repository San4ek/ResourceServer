package com.example.demoapi.repositories;

import com.example.demoapi.models.Ingredient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
    @Modifying
    @Query("delete from Ingredient ingredient where ingredient.id in ?1")
    void deleteAllByIdIn(List<String> ids);

    Page<Iterable<Ingredient>> findAll(Pageable pageable);
}
