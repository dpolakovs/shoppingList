package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.enums.ProductCategory;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.Scanner;
@Component
public class ConsoleUi {
    private ProductService productService;

    @Autowired
    public ConsoleUi(ProductService productService) {
        this.productService = productService;
    }

    public void execute() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Delete product by id");
                System.out.println("3. Change product name");
                System.out.println("4. Change product price");
                System.out.println("5. Exit");
                String userInput = scanner.nextLine();
                switch (userInput) {
                    case "1":
                        createProduct();
                        break;
                    case "2":
                        deleteProduct();
                        break;
                    case "3":
                        changeProductName();
                        break;
                    case "4":
                        changeProductPrice();
                        break;
                    case "5":
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
                System.out.println(e.getMessage());
            }
        }
    }

    private void createProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter product price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());

        System.out.println("Enter Product category: ");
        System.out.println("1. Alcohol");
        System.out.println("2. Fruits");
        System.out.println("3. Meat");
        System.out.println("4. Dairy");
        System.out.println("5. Vegetables");

        ProductCategory category = null;

        switch (scanner.nextLine()) {
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

        System.out.println("Enter Product discount: ");

        Scanner scanner1 = new Scanner(System.in);
        BigDecimal discount = new BigDecimal(scanner1.nextLine());

        System.out.println("Enter Product description: ");
        Scanner scanner2 = new Scanner(System.in);
        String description = new String(scanner2.nextLine());

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setCategory(category);
        product.setDiscount(discount);
        product.setDescription(description);

        Long id = productService.createProduct(product);

        product.printInformation();
        System.out.println();
    }

    private void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        Long id = scanner.nextLong();
        productService.delete(id);
        System.out.println("Product was deleted!");
        System.out.println();
    }

    private void changeProductName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        Long id = Long.valueOf(scanner.nextLine());
        System.out.println("Enter product name: ");
        String name = String.valueOf(scanner.nextLine());
        productService.changeProductName(id, name);
        System.out.println("Name was changed! Actual name is: " + name);
        System.out.println();
    }

    private void changeProductPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        Long id = Long.valueOf(scanner.nextLine());
        System.out.println("Enter product price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());
        productService.changeProductPrice(id, price);
        System.out.println("Price was changed! Actual price is: " + price);
        System.out.println();
    }
}
