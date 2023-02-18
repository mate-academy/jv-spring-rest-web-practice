package mate.academy.spring.mapper.impl.request;

import java.util.Collection;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class OrderRequestMapper implements DtoRequestMapper<OrderRequestDto, Order> {
    private final UserService userService;
    private final OrderService orderService;

    public OrderRequestMapper(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @Override
    public Order fromDto(OrderRequestDto orderRequestDto) {
        return new Order(orderRequestDto.getTicketIds()
                .stream()
                .map(userService::get)
                .map(orderService::getOrdersHistory)
                .flatMap(Collection::stream)
                .map(Order::getTickets)
                .flatMap(Collection::stream)
                .collect(Collectors.toList()),
                orderRequestDto.getOrderDate(),
                userService.get(orderRequestDto.getUserId()));
    }
}
