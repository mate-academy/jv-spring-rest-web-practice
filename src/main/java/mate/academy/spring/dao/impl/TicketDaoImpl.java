package mate.academy.spring.dao.impl;

import java.util.List;
import mate.academy.spring.dao.AbstractDao;
import mate.academy.spring.dao.TicketDao;
import mate.academy.spring.exception.DataProcessingException;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoImpl extends AbstractDao<Ticket> implements TicketDao {
    public TicketDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Ticket> getTicketsByUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            Query<Ticket> query = session.createQuery("FROM Ticket t "
                    + "left join fetch t.movieSession "
                    + "left join fetch t.user "
                    + "WHERE o.user = :user", Ticket.class);
            query.setParameter("user", user);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Cannot find tickets by user: " + "user", e);
        }
    }
}
