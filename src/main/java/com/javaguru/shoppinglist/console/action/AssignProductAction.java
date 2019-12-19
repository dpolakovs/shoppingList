package com.javaguru.shoppinglist.console.action;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.validation.ShoppingCartService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Scanner;

@Component
class AssignProductAction implements Action {

    private static final String ACTION_NAME = "Assign product to shoppingCart";

    private final ProductService productService;
    private final ShoppingCartService shoppingCartService;

    AssignProductAction(ProductService productService, ShoppingCartService shoppingCartService) {
        this.productService = productService;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    @Transactional
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter shoppingCart id:");
        Long shoppingCartId = scanner.nextLong();
        System.out.println("Enter product id: ");
        Long productId = scanner.nextLong();

        Product product = productService.findById(productId);
        shoppingCartService.addProductToShoppingCart(product, shoppingCartId);
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
