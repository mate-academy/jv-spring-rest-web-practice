package mate.academy.spring.mapper.impl.request;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import mate.academy.spring.service.TicketService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderRequestMapper implements DtoRequestMapper<OrderRequestDto, Order> {
    private final TicketService ticketService;
    private final UserService userService;

    @Autowired
    public OrderRequestMapper(TicketService ticketService, UserService userService) {
        this.ticketService = ticketService;
        this.userService = userService;
    }

    @Override
    public Order fromDto(OrderRequestDto orderRequestDto) {
        List<Ticket> tickets = orderRequestDto.getTicketsIds().stream()
                .map(ticketService::get)
                .collect(Collectors.toList());
        Order order = new Order();
        order.setTickets(tickets);
        order.setOrderDate(orderRequestDto.getOrderDate());
        order.setUser(userService.get(orderRequestDto.getUserId()));
        return order;
    }
}
