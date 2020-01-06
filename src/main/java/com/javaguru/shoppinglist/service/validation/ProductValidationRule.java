package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;

public interface ProductValidationRule {
    void validate(ProductDTO productDto);

    void checkNotNull(ProductDTO productDto);
}
