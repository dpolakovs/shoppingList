package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class ProductService {

    public ProductRepository repository;
    public ProductValidationService validationService;

    @Autowired
    public ProductService(ProductRepository repository , ProductValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    @Transactional
    public Product createProduct(Product product) {
        validationService.validate ( product );
        return repository.save ( product );
    }

    public void delete(Long id) {
        repository.delete ( id );
    }

    public void update(Product product) {
        repository.update ( product );
    }

    public Product findById(Long id) {
        return repository.findProductById ( id )
                .orElseThrow ( () -> new NoSuchElementException ( "Product not found, id: " + id ) );
    }

    public List<Product> findAll(){
        return repository.findAll ();
    }
}
