package mate.academy.spring.dao;

import mate.academy.spring.model.Ticket;

import java.util.Optional;

public interface TicketDao extends GenericDao<Ticket> {

    public Optional<Ticket> get(Long id);
}
