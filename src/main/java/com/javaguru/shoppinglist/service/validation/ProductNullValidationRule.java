package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductNullValidationRule implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        checkNotNull(product);
    }

    @Override
    public void checkNotNull(Product product) {
        if (product == null) {
            throw new ProductValidationException("Product must not be null");
        }
    }
}

