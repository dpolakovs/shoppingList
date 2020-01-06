package com.javaguru.shoppinglist.mapper;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public Product convert(ProductDTO dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setDiscount(dto.getDiscount());
        product.setCategory(dto.getCategory());
        product.setDescription(dto.getDescription());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        return product;
    }

    public ProductDTO convert(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setCategory(product.getCategory());
        dto.setDescription(product.getDescription());
        dto.setDiscount(product.getDiscount());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        return dto;
    }
}
