package mate.academy.spring.mapper.impl.request;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import mate.academy.spring.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class OrderRequestMapper implements DtoRequestMapper<OrderRequestDto, Order> {
    private final UserService userService;

    public OrderRequestMapper(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Order fromDto(OrderRequestDto dto) {
        Order order = new Order();
        List<Ticket> tickets = dto.getTicketsId().stream()
                .map(Ticket::new)
                .collect(Collectors.toList());
        order.setTickets(tickets);
        order.setOrderDate(dto.getOrderDate());
        order.setUser(userService.get(dto.getUserId()));
        return order;
    }
}
