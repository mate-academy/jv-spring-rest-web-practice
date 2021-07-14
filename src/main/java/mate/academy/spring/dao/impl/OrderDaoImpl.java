package mate.academy.spring.dao.impl;

import java.util.List;
import mate.academy.spring.dao.AbstractDao;
import mate.academy.spring.dao.OrderDao;
import mate.academy.spring.exception.DataProcessingException;
import mate.academy.spring.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {
    public OrderDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Order> getOrdersHistory(Long userId) {
        try (Session session = sessionFactory.openSession()) {
            Query<Order> query = session.createQuery("FROM Order o "
                    + "left join fetch o.tickets "
                    + "left join fetch o.user u "
                    + "WHERE u.id = :userId", Order.class);
            query.setParameter("userId", userId);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Cannot find orders of user by user ID: "
                    + userId, e);
        }
    }
}
