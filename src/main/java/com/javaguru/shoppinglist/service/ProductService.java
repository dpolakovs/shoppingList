package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.mapper.ProductConverter;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ProductService {

    public ProductRepository repository;
    public ProductValidationService validationService;
    private final ProductConverter converter;

    @Autowired
    public ProductService(ProductRepository repository , ProductValidationService validationService , ProductConverter converter) {
        this.repository = repository;
        this.validationService = validationService;
        this.converter = converter;
    }

    public Long createProduct(ProductDTO productdto) {
        Product product = converter.convert(productdto);
        Product createdProduct = repository.save(product);
        return createdProduct.getId();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void update(ProductDTO dto){
        Product product = converter.convert(dto);
        repository.update(product);
    }

    public Product findById(Long id) {
        return repository.findProductById ( id )
                .orElseThrow ( () -> new NoSuchElementException ( "Product not found, id: " + id ) );
    }

    public List<ProductDTO> findAll() {
        return repository.findAll().stream()
                .map(product -> converter.convert(product))
                .collect( Collectors.toList());
    }}
