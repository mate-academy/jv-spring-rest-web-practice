package mate.academy.spring.mapper.impl.request;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import mate.academy.spring.service.TicketService;
import mate.academy.spring.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class OrderRequestMapper implements DtoRequestMapper<OrderRequestDto, Order> {
    private UserService userService;
    private TicketService ticketService;

    public OrderRequestMapper(UserService userService, TicketService ticketService) {
        this.userService = userService;
        this.ticketService = ticketService;
    }

    @Override
    public Order fromDto(OrderRequestDto dto) {
        Order order = new Order();
        List<Ticket> tickets = dto.getTicketIds().stream()
                .map(ticketService::get)
                .collect(Collectors.toList());
        order.setTickets(tickets);
        User user = userService.get(dto.getUserId());
        order.setUser(user);
        order.setOrderDate(dto.getOrderDate());
        return order;
    }

}
