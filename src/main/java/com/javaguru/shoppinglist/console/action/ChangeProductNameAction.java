package com.javaguru.shoppinglist.console.action;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ChangeProductNameAction implements Action {
    private static final String ACTION_NAME = "Change Product name";

    private final ProductService productService;
    private Product product;

    public ChangeProductNameAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner ( System.in );
        System.out.println ( "Enter product id: " );
        Long id = Long.valueOf ( scanner.nextLine () );
        System.out.println ( "Enter new product name: " );
        String name = String.valueOf ( scanner.nextLine () );
        productService.update ( product );
        System.out.println ( "Name was changed! Actual name is: " + name );
    }
}
