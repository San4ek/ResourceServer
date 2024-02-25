package com.example.demoapi.repositories;

import com.example.demoapi.models.Taco;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacoRepository extends CrudRepository<Taco, Long> {
    List<Taco> findAll(Pageable pageable);
}
