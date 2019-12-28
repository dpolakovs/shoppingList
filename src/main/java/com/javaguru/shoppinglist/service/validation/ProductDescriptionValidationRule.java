package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductDescriptionValidationRule implements ProductValidationRule {

    @Override
    public void validate(ProductDTO productDto) {
        checkNotNull ( productDto );
        descriptionLengthValidation ( productDto.getDescription () );
    }

    @Override
    public void checkNotNull(ProductDTO productDto) {
        if (productDto.getDescription () == null) {
            throw new ProductValidationException ( "Product description must not be null!" );
        }
    }

    private void descriptionLengthValidation(String description) {
        if (description.length () > 150) {
            throw new ProductValidationException ( "Error! Description is too long." );
        }
    }
}
