package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.Optional;

public interface ProductRepository {

    Product save(Product product);

    void update(Product product);

    Optional<Product> findTaskById(Long id);

    void delete(Long id);

    boolean existsByName(String name);


}
