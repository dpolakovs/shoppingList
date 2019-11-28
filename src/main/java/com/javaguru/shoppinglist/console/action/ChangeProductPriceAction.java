package com.javaguru.shoppinglist.console.action;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class ChangeProductPriceAction implements Action {
    private static final String ACTION_NAME = "Change Product price";

    private final ProductService productService;
    private Product product;

    public ChangeProductPriceAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner ( System.in );
        System.out.println ( "Enter product id: " );
        Long id = Long.valueOf ( scanner.nextLine () );
        System.out.println ( "Enter new product price: " );
        BigDecimal price = new BigDecimal ( scanner.nextLine () );
        productService.update ( product );
        System.out.println ( "Price was changed! Actual price is: " + price );
    }
    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
