package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.repository.HibernateShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class ShoppingCartService {

    private final HibernateShoppingCartRepository shoppingCartRepository;

    @Autowired
    public ShoppingCartService(HibernateShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public Long createShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    public ShoppingCart findShoppingCartById(Long shoppingCartId) {
        return shoppingCartRepository.findUserById(shoppingCartId)
                .orElseThrow(() -> new NoSuchElementException ("Shopping cart not found, id: " + shoppingCartId));
    }

    public void addProductToShoppingCart(Product product, Long shoppingCartId) {
        ShoppingCart shoppingCart = findShoppingCartById(shoppingCartId);
        shoppingCart.getProducts ().add(product);
        shoppingCartRepository.update(shoppingCart);
    }
}
