package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.dto.ShoppingCartDTO;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.ShoppingCartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carts")
public class ShoppingCartController {

    private final ShoppingCartService service;

    public ShoppingCartController(ShoppingCartService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ShoppingCart> create(@RequestBody ShoppingCartDTO dto) {
        ShoppingCart cart = new ShoppingCart();
        cart.setLogin (dto.getLogin ());
        cart.setDescription (dto.getDescription ());
        service.createCart(dto);
        return ResponseEntity.ok(cart);
    }
    @GetMapping("/{id}")
    public ShoppingCartDTO findCartById(@PathVariable("id") Long Id){
        return service.findCartById ( Id );
    }

    @GetMapping
    public List<ShoppingCartDTO> findAll(){
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        service.deleteById(id);
    }

    @PutMapping("/{id}carts{cartId}")
    public void update(@PathVariable("id") Long id, @PathVariable("cartId") Long cartId,
                       @RequestBody ProductDTO dto, @RequestBody ShoppingCartDTO dtocart) {
        service.saveProductToList(dto, dtocart);
    }

}
