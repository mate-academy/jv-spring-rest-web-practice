package mate.academy.spring.service.dto.mapping.impl.request;

import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderRequestMapper implements DtoRequestMapper<OrderRequestDto, Order> {
    private final UserService userService;

    public OrderRequestMapper(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Order parseFromDto(OrderRequestDto dto) {
        Order order = new Order();
        order.setTickets(dto.getTickets());
        order.setOrderDate(dto.getOrderDate());
        order.setUser(userService.get(dto.getUserId()));
        return order;
    }
}
