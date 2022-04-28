package mate.academy.spring.mapper.impl.request;

import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import mate.academy.spring.service.TicketService;
import mate.academy.spring.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class OrderRequestMapper implements DtoRequestMapper<OrderRequestDto, Order> {
    private final UserService userService;
    private final TicketService ticketService;

    public OrderRequestMapper(UserService userService, TicketService ticketService) {
        this.userService = userService;
        this.ticketService = ticketService;
    }

    @Override
    public Order fromDto(OrderRequestDto dto) {
        Order order = new Order();
        order.setOrderDate(dto.getOrderDate());
        order.setUser(userService.get(dto.getUserId()));
        order.setTickets(dto.getListOfTicketIds().stream()
                .map(ticketService::get)
                .collect(Collectors.toList()));
        return order;
    }
}
