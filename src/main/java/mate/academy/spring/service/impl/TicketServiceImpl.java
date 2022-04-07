package mate.academy.spring.service.impl;

import java.util.List;
import mate.academy.spring.dao.TicketDao;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.User;
import mate.academy.spring.service.TicketService;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketDao ticketDao;

    public TicketServiceImpl(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    @Override
    public List<Ticket> getTicketsByUser(User user) {
        return ticketDao.getTicketsByUser(user);
    }
}
