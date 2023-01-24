package mate.academy.spring.mapper.impl.request;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.User;
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
        User user = userService.get(dto.getUser().getId());
        order.setOrderDate(dto.getOrderDate());
        order.setTickets(dto.getTickets());
        order.setUser(user);
        return order;
    }
}
