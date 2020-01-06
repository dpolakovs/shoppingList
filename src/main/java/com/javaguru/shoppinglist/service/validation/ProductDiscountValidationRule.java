package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductDiscountValidationRule implements ProductValidationRule {

    private final BigDecimal MAX_DISCOUNT = new BigDecimal ( 80 ).setScale ( 0 , BigDecimal.ROUND_DOWN );
    private final BigDecimal MIN_DISCOUNT = new BigDecimal ( 0 ).setScale ( 0 , BigDecimal.ROUND_DOWN );

    @Override
    public void validate(ProductDTO productDto) {
        checkNotNull ( productDto );
        discountAmountValidation ( productDto );
        checkMinPriceForDiscount ( productDto );
    }

    @Override
    public void checkNotNull(ProductDTO productDto) {
        if (productDto.getDiscount () == null) {
            throw new ProductValidationException ( "Product discount must not be null!" );
        }
    }

    public void discountAmountValidation(ProductDTO productDto) {
        if (productDto.getDiscount ().compareTo ( MAX_DISCOUNT ) > 0) {
            throw new ProductValidationException ( "Error! The discount can not be more than 80%" );
        }
        if (productDto.getDiscount ().compareTo ( MIN_DISCOUNT ) < 0) {
            throw new ProductValidationException ( "Error! The discount can not be negative" );
        }
    }

    private void checkMinPriceForDiscount(ProductDTO productDto) {
        if ((productDto.getPrice ().compareTo ( BigDecimal.valueOf ( 20 ) ) < 0) && (productDto.getDiscount ().compareTo ( MIN_DISCOUNT ) > 0)) {
            throw new ProductValidationException ( "Error! Insufficient price for discount" );
        }
    }
}
