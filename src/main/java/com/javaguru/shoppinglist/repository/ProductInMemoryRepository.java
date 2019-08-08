package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class ProductInMemoryRepository {
    private Map<Long, Product> products = new HashMap<>();
    private Long productIdSequence = 0L;

    public Product put(Product product) {
        products.put(productIdSequence, product);
        product.setId(productIdSequence);
        productIdSequence++;
        return product;
    }

    public void delete(Long id) {
        if (!products.containsKey(id)) {
            System.out.println("ID not found!");
        } else {
            products.remove(id);
        }
    }

    public void changeProductName(Long id, String name) {
        if (!products.containsKey(id)) {
            System.out.println("ID not found!");
        } else {
            products.get(id).setName(name);
        }
    }

    public void changeProductPrice(Long id, BigDecimal price) {
        if (!products.containsKey(id)) {
            System.out.println("ID not found!");
        } else {
            products.get(id).setPrice(price);
        }
    }

    public void changeProductDiscount(Long id, BigDecimal discount){
        if(!products.containsKey(id)) {
            System.out.println("ID not found!");
        }else{
            products.get(id).setDiscount(discount);
        }
    }

    public void changeProductDescription(Long id, String description){
        if(!products.containsKey(id)) {
            System.out.println("ID not found!");
        }else{
            products.get(id).setDescription(description);
        }
    }

    public boolean existsByName(String name) {
        return products.values().stream()
                .anyMatch(product -> product.getName().equalsIgnoreCase(name));
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    public Optional<Product> findByName(String name) {
        return products.values().stream()
                .filter(task -> task.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
