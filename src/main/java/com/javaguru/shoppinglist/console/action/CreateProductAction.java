package com.javaguru.shoppinglist.console.action;


import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.enums.ProductCategory;
import com.javaguru.shoppinglist.service.validation.ProductValidationException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class CreateProductAction implements Action {
    private static final String ACTION_NAME = "Create Product";

    private final ProductService productService;

    public CreateProductAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner ( System.in );
        System.out.println ( "Enter Product name: " );
        String name = scanner.nextLine ();
        System.out.println ( "Enter product price: " );
        BigDecimal price = new BigDecimal ( scanner.nextLine () );

        System.out.println ( "Enter Product category: " );
        System.out.println ( "1. Alcohol" );
        System.out.println ( "2. Fruits" );
        System.out.println ( "3. Meat" );
        System.out.println ( "4. Dairy" );
        System.out.println ( "5. Vegetables" );

        ProductCategory category = null;

        switch (scanner.nextLine ()) {
            case "1":
                category = ProductCategory.ALCOHOL;
                break;
            case "2":
                category = ProductCategory.FRUITS;
                break;
            case "3":
                category = ProductCategory.MEAT;
                break;
            case "4":
                category = ProductCategory.DAIRY;
                break;
            case "5":
                category = ProductCategory.VEGETABLES;
                break;
        }

        System.out.println ( "Enter Product discount: " );

        Scanner scanner1 = new Scanner ( System.in );
        BigDecimal discount = new BigDecimal ( scanner1.nextLine () );

        System.out.println ( "Enter Product description: " );
        Scanner scanner2 = new Scanner ( System.in );
        String description = scanner2.nextLine ();

        Product product = new Product ();
        product.setName ( name );
        product.setPrice ( price );
        product.setCategory ( category );
        product.setDiscount ( discount );
        product.setDescription ( description );
        try {
            Long response = productService.createProduct ( product );
            System.out.println ( "Response: " + response );
        } catch (ProductValidationException e) {
            System.out.println ( e.getMessage () );
        }
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
