package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.dto.ShoppingCartDTO;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Profile ("hibernate")
@Transactional
public class  HibernateShoppingCartRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    HibernateShoppingCartRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public ShoppingCart save(ShoppingCart shoppingCart) {
        sessionFactory.getCurrentSession().save(shoppingCart);
        return shoppingCart;
    }

    public void update(ShoppingCart shoppingCart) {
        sessionFactory.getCurrentSession().saveOrUpdate(shoppingCart);
    }

    public Optional<ShoppingCart> findCartById(Long id) {
        ShoppingCart shoppingCart = (ShoppingCart) sessionFactory.getCurrentSession().createCriteria(ShoppingCart.class)
                .add( Restrictions.eq("id", id))
                .uniqueResult();
        return Optional.ofNullable(shoppingCart);
    }

    public List<ShoppingCart> findAll() {
        return sessionFactory.getCurrentSession()
                .createCriteria(ShoppingCart.class).list();
    }

    public void deleteById(Long id){
        ShoppingCart cart = (ShoppingCart) sessionFactory.getCurrentSession().load(ShoppingCart.class, id);
        sessionFactory.getCurrentSession().delete(cart);
    }
    public void saveProductToList(Product product, ShoppingCart cart){
        cart.getProducts().add(product);
        sessionFactory.getCurrentSession().saveOrUpdate(cart);
    }
}
