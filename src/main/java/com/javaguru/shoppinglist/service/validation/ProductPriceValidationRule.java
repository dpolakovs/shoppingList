package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductPriceValidationRule implements ProductValidationRule {

    private final BigDecimal MIN_PRICE = new BigDecimal(0.01).setScale(2, BigDecimal.ROUND_DOWN);

    @Override
    public void validate(Product product) {
        if ((product.getPrice().compareTo(MIN_PRICE) < 0)) {
            throw new ProductValidationException("Error! The price can not be less than " + MIN_PRICE + "Eur");
        }
    }

    @Override
    public void checkNotNull(Product product) {
        if (product.getPrice() == null) {
            throw new ProductValidationException("Product price must not be null!");
        }
    }
}
