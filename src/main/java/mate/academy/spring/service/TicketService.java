package mate.academy.spring.service;

import java.util.List;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.User;

public interface TicketService {
    List<Ticket> getTicketsByUser(User user);
}
