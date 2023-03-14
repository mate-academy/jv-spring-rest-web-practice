package mate.academy.spring.mapper.impl.request;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dao.TicketDao;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderRequestMapper implements DtoRequestMapper<OrderRequestDto, Order> {
    @Autowired
    private UserService userService;
    @Autowired
    private TicketDao ticketDao;

    @Override
    public Order fromDto(OrderRequestDto dto) {
        Order order = new Order();
        order.setOrderDate(dto.getOrderDate());
        order.setUser(userService.get(dto.getUserId()));
        List<Ticket> tickets = new ArrayList<>();
        tickets.stream()
                .map(ticket -> ticket = ticketDao.get(dto.getUserId()).get())
                .collect(Collectors.toList());
        order.setTickets(tickets);
        return order;
    }
}
