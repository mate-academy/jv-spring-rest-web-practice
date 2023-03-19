package mate.academy.spring.dao.impl;

import java.util.List;
import mate.academy.spring.dao.AbstractDao;
import mate.academy.spring.dao.OrderDao;
import mate.academy.spring.exception.DataProcessingException;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.User;
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
    public List<Order> getOrdersHistory(User user) {
        try (Session session = sessionFactory.openSession()) {
            Query<Order> query = session.createQuery("select distinct o "
                    + "from Order o "
                    + "left join fetch o.tickets t "
                    + "left join fetch t.movieSession m "
                    + "left join fetch m.movie "
                    + "left join fetch m.cinemaHall "
                    + "left join fetch o.user "
                    + "WHERE o.user = :user", Order.class);
            query.setParameter("user", user);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Cannot find orders of user by user: " + "user", e);
        }
    }
}
