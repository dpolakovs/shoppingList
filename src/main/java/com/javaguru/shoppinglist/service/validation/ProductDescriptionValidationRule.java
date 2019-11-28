package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDescriptionValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        checkNotNull ( product );
        descriptionLengthValidation ( product.getDescription () );
    }

    @Override
    public void checkNotNull(Product product) {
        if (product.getDescription () == null) {
            throw new ProductValidationException ( "Product description must not be null!" );
        }
    }

    private void descriptionLengthValidation(String description) {
        if (description.length () > 150) {
            throw new ProductValidationException ( "Error! Description is too long." );
        }
    }
}
