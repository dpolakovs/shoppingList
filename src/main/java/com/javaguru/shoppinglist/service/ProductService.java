package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.NoSuchElementException;

@Component
public class ProductService {

    private static ProductInMemoryRepository repository;
    private static ProductValidationService validationService;

    @Autowired
    public ProductService(ProductInMemoryRepository repository , ProductValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    @Transactional
    public Long createProduct(Product product) {
        validationService.validate ( product );
        Product createdProduct = repository.put ( product );
       return createdProduct.getId ();
    }

    public void delete(Long id) {
        repository.delete ( id );
    }

    public void changeProductName(Long id , String name) {
        repository.changeProductName ( id , name );
    }

    public void changeProductPrice(Long id , BigDecimal price) {
        repository.changeProductPrice ( id , price );
    }

    public void changeProductDescription(Long id , String description) {
        repository.changeProductDescription ( id , description );
    }

    public static Product findById(Long id) {
        return repository.findById ( id )
                .orElseThrow ( () -> new NoSuchElementException ( "Product not found, id: " + id ) );
    }
}
