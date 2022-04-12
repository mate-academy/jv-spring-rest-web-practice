package mate.academy.spring.dao;

import java.util.List;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.User;

public interface TicketDao extends GenericDao<Ticket> {
    List<Ticket> getTicketsByUser(User user);
}
