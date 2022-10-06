package mate.academy.spring.dao.impl;

import mate.academy.spring.dao.AbstractDao;
import mate.academy.spring.dao.TicketDao;
import mate.academy.spring.exception.DataProcessingException;
import mate.academy.spring.model.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoImpl extends AbstractDao<Ticket> implements TicketDao {
    public TicketDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Ticket add(Ticket ticket) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't add ticket: " + ticket, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return ticket;
    }
}
