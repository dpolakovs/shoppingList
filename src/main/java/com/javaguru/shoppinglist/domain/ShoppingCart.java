package com.javaguru.shoppinglist.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "shoppingCarts")
public class ShoppingCart {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "login", nullable = false, unique = true)
    private String login;
    @Column(name = "password", nullable = false)
    private String password;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "shoppingCart_id")
    private Set<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart shoppingCart = (ShoppingCart) o;
        return Objects.equals(id, shoppingCart.id) &&
                Objects.equals(login, shoppingCart.login) &&
                Objects.equals(password, shoppingCart.password) &&
                Objects.equals(products, shoppingCart.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, products);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password=*******" +
                ", products=" + products +
                '}';
    }
}
