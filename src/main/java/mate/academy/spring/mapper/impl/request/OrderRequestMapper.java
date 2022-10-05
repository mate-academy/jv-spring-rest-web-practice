package mate.academy.spring.mapper.impl.request;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import org.springframework.stereotype.Component;

@Component
public class OrderRequestMapper implements DtoRequestMapper<OrderRequestDto, Order> {
    private final OrderService orderService;
    private final UserService userService;

    public OrderRequestMapper(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @Override
    public Order fromDto(OrderRequestDto dto) {
        Order order = new Order();
        User user = userService.get(dto.getUserId());
        List<Order> ordersHistory = orderService.getOrdersHistory(user);
        List<Ticket> tickets = ordersHistory.stream().map(Order::getTickets)
                .flatMap(List::stream).collect(Collectors.toList());
        order.setUser(user);
        order.setTickets(tickets);
        order.setOrderDate(dto.getOrderDate());
        return order;
    }
}
