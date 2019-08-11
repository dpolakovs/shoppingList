package com.javaguru.shoppinglist.console.action;

import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class ChangeProductPriceAction implements Action {
    private static final String ACTION_NAME = "Change Product price";

    private final ProductService productService;

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
        productService.changeProductPrice ( id , price );
        System.out.println ( "Price was changed! Actual price is: " + price );
    }
}
