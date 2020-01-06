package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductNullValidationRule implements ProductValidationRule {
    @Override
    public void validate(ProductDTO productDto) {
        checkNotNull ( productDto );
    }

    @Override
    public void checkNotNull(ProductDTO productDto) {
        if (productDto == null) {
            throw new ProductValidationException ( "Product must not be null" );
        }
    }
}

