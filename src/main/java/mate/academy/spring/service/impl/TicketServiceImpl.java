package mate.academy.spring.service.impl;

import mate.academy.spring.dao.TicketDao;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.service.TicketService;

public class TicketServiceImpl implements TicketService {
    private TicketDao ticketDao;

    public TicketServiceImpl(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    @Override
    public Ticket get(Long id) {
        return ticketDao.get(id).get();
    }
}
