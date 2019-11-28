package com.javaguru.shoppinglist.console.action;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.service.validation.ShoppingCartService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CreateShoppingCartAction implements Action {
    private static final String ACTION_NAME = "Create shoppingCart";

    private final ShoppingCartService shoppingCartService;

    public CreateShoppingCartAction(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter shopping cart login:");
        String name = scanner.nextLine();
        System.out.println("Enter shopping cart password: ");
        String description = scanner.nextLine();

        ShoppingCart shoppingCart = new ShoppingCart ();
        shoppingCart.setLogin(name);
        shoppingCart.setPassword(description);

        Long response = shoppingCartService.createShoppingCart (shoppingCart);
        System.out.println("Response: " + response);
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
