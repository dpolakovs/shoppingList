package com.javaguru.shoppinglist.dto;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

public class ShoppingCartDTO {

    private Long id;
    private String login;
    private String password;
    private Set<Product> products;

    public ShoppingCartDTO(Long id , String login , String password , Set<Product> products) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.products = products;
    }

    public ShoppingCartDTO() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        ShoppingCartDTO that = (ShoppingCartDTO) o;
        return Objects.equals ( id , that.id ) &&
                Objects.equals ( login , that.login ) &&
                Objects.equals ( password , that.password );
    }

    @Override
    public int hashCode() {
        return Objects.hash ( id , login , password );
    }

    @Override
    public String
    toString() {
        return "ShoppingCartDTO{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
