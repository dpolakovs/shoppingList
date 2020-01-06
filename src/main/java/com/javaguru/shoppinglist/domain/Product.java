package com.javaguru.shoppinglist.domain;

import com.javaguru.shoppinglist.service.enums.ProductCategory;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

import static java.math.BigDecimal.valueOf;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "category")
    @Enumerated(value = EnumType.STRING)
    private ProductCategory category;
    @Column(name = "discount")
    private BigDecimal discount;
    @Column(name = "description")
    private String description;
    @Column(name = "shoppingCarts_id")

    private Long shoppingCartId;

    public Long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal priceWithDiscount() {
        return price.subtract(getPrice().multiply(getDiscount()).divide(valueOf(100)));    }

    public void printInformation() {
        System.out.println ( "Product id - " + id );
        System.out.println ( "Name of product - " + name );
        System.out.println ( "Product category - " + category );
        System.out.println ( "Regular price of product = " + price + " EUR" );
        System.out.println ( "Description: " + description );
        System.out.println ("Shopping cart id = "+ shoppingCartId);
        if ((discount.compareTo (valueOf ( 1 ) ) > 0)) {
            System.out.println ( "Discount on product = " + discount + " %" );
            System.out.println ( "Price with discount = " + priceWithDiscount () + " EUR" );
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Product product = (Product) o;
        return Objects.equals ( id , product.id ) &&
                Objects.equals ( name , product.name ) &&
                Objects.equals ( price , product.price ) &&
                category == product.category &&
                Objects.equals ( discount , product.discount ) &&
                Objects.equals ( description , product.description ) &&
                Objects.equals(shoppingCartId, product.shoppingCartId);
    }

    @Override
    public int hashCode() {
        return Objects.hash ( id , name , price , category , discount , description, shoppingCartId );
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", discount=" + discount +
                ", description='" + description + '\'' +
                ", shoppingCartId='" + shoppingCartId + '\'' +
                '}';
    }
}