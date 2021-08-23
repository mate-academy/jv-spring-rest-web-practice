package mate.academy.spring.dao.impl;

import java.util.Optional;
import mate.academy.spring.dao.AbstractDao;
import mate.academy.spring.dao.TicketDao;
import mate.academy.spring.model.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoImpl extends AbstractDao<Ticket> implements TicketDao {
    public TicketDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Ticket t where t.id = :id", Ticket.class)
                    .setParameter("id", id)
                    .uniqueResultOptional();
        }
    }
}
