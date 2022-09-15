package mate.academy.spring.dao;

import java.util.Optional;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Ticket;

public interface TicketDao extends GenericDao<Ticket> {
    Optional<Ticket> get(Long id);
}
