package mate.academy.spring.service;

import java.util.Optional;
import mate.academy.spring.model.Ticket;

public interface TicketService {
    Optional<Ticket> findById(Long id);
}
