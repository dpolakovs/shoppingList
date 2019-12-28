package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void update(Product product);

    Optional<Product> findProductById(Long id);

    Product save(Product product);

    void deleteById(Long id);

    boolean existsByName(String name);

    List<Product> findAll();
}
