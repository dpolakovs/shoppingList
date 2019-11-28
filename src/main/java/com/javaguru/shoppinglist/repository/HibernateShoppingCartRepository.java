package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public class HibernateShoppingCartRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    HibernateShoppingCartRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long save(ShoppingCart shoppingCart) {
        sessionFactory.getCurrentSession().save(shoppingCart);
        return shoppingCart.getId();
    }

    public void update(ShoppingCart shoppingCart) {
        sessionFactory.getCurrentSession().update(shoppingCart);
    }

    public Optional<ShoppingCart> findUserById(Long id) {
        ShoppingCart user = (ShoppingCart) sessionFactory.getCurrentSession().createCriteria(ShoppingCart.class)
                .add( Restrictions.eq("id", id))
                .uniqueResult();
        return Optional.ofNullable(user);
    }
}
