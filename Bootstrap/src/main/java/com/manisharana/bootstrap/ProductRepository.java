package com.manisharana.bootstrap;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Override
    Iterable<Product> findAll();

    List<Product> findByName(String name);

}
