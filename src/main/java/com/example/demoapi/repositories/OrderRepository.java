package com.example.demoapi.repositories;

import com.example.demoapi.models.TacoOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

    Page<TacoOrder> findAllByUser_Username(String username, Pageable pageable);

}
