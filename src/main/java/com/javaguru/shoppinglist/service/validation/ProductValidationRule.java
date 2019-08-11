package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public interface ProductValidationRule {
    void validate(Product product);

    void checkNotNull(Product product);
}
