package mate.academy.spring.dao.impl;

import mate.academy.spring.dao.AbstractDao;
import mate.academy.spring.dao.ShoppingCartDao;
import mate.academy.spring.exception.DataProcessingException;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ShoppingCartDaoImpl extends AbstractDao<ShoppingCart> implements ShoppingCartDao {
    public ShoppingCartDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, ShoppingCart.class);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        try (Session session = factory.openSession()) {
            Query<ShoppingCart> query = session.createQuery("FROM ShoppingCart shc "
                    + "LEFT JOIN FETCH shc.tickets t "
                    + "WHERE shc.id = :id", ShoppingCart.class);
            return query.setParameter("id", user.getId()).getSingleResult();
        } catch (Exception e) {
            throw new DataProcessingException("Cannot find shopping cart using user ", e);
        }
    }
}
