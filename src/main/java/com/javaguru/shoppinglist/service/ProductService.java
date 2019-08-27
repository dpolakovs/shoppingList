package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.HibernateProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;

@Component
public class ProductService {

    public HibernateProductRepository repository;
    public ProductValidationService validationService;

    @Autowired
    public ProductService(HibernateProductRepository repository , ProductValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    @Transactional
    public Long createProduct(Product product) {
        validationService.validate ( product );
        Product createdProduct = repository.save ( product );
        return createdProduct.getId ();
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
}
