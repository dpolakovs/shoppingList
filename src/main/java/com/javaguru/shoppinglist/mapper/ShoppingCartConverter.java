package com.javaguru.shoppinglist.mapper;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.dto.ShoppingCartDTO;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartConverter {
    public ShoppingCart convert(ShoppingCartDTO dto) {
        ShoppingCart cart = new ShoppingCart();
        cart.setId(dto.getId());
        cart.setLogin (dto.getLogin ());
        cart.setPassword (dto.getPassword ());
        cart.setProducts (dto.getProducts ());
        return cart;
    }

    public ShoppingCartDTO convert(ShoppingCart cart) {
        ShoppingCartDTO dto = new ShoppingCartDTO ();
        dto.setId(cart.getId());
        dto.setLogin (cart.getLogin ());
        dto.setPassword (dto.getPassword ());
        dto.setProducts (dto.getProducts ());
        return dto;
    }
}
