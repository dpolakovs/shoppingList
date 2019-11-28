package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductValidationService {

    private final List<ProductValidationRule> validationRules;

    public ProductValidationService(List<ProductValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public void validate(Product product) {
        validationRules.forEach ( s -> s.validate ( product ) );
    }
}