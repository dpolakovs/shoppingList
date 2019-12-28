package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.dto.ShoppingCartDTO;
import com.javaguru.shoppinglist.mapper.ProductConverter;
import com.javaguru.shoppinglist.mapper.ShoppingCartConverter;
import com.javaguru.shoppinglist.repository.HibernateShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartService {

    private final HibernateShoppingCartRepository repository;
    private final ShoppingCartConverter converter;
    private final ProductConverter productconverter;

    @Autowired
    public ShoppingCartService(HibernateShoppingCartRepository repository, ShoppingCartConverter converter, ProductConverter productconverter) {
        this.repository = repository;
        this.converter = converter;
        this.productconverter = productconverter;
    }

    public ShoppingCartDTO saveProductToList(ProductDTO productdto, ShoppingCartDTO cartDto){
        ShoppingCart cart = converter.convert(cartDto);
        Product product = productconverter.convert(productdto);
        repository.saveProductToList(product, cart);
        return cartDto;
    }

    public Long createCart(ShoppingCartDTO cartDto) {
        ShoppingCart cart = converter.convert(cartDto);
        ShoppingCart createdCart = repository.save(cart);
        return createdCart.getId();
    }

    public void update(ShoppingCartDTO dto) {
        ShoppingCart cart = converter.convert(dto);
        repository.update(cart);
    }

    public List<ShoppingCartDTO> findAll() {
        return repository.findAll().stream()
                .map(shoppingCart -> converter.convert(shoppingCart))
                .collect( Collectors.toList());
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}