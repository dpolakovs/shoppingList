package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/new")
    public ResponseEntity<Product> create(@RequestBody ProductDTO productDTO) {
         Product product = new Product();
         product.setName(productDTO.getName());
         product.setCategory ( productDTO.getCategory () );
         product.setPrice ( productDTO.getPrice () );
         product.setDiscount ( productDTO.getDiscount () );
         product.setDescription(productDTO.getDescription());
         productService.createProduct (productDTO);
         return ResponseEntity.ok(product);
     }

    @GetMapping("/{id}")
    public ProductDTO findProductById(@PathVariable("id") Long id) {
        return productService.findById (id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        productService.delete ( id );
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Long id, @RequestBody ProductDTO productDTO){
        productService.update(productDTO);
    }
    @GetMapping
    public List<ProductDTO> findAll() {
        return productService.findAll();
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleNoSuchElementException(NoSuchElementException ex) {
    }
}
