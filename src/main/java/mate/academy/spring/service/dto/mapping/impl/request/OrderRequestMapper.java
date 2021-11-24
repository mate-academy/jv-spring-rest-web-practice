package mate.academy.spring.service.dto.mapping.impl.request;

import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderRequestMapper implements DtoRequestMapper<OrderRequestDto, Order> {
    private final UserService userService;

    @Autowired
    public OrderRequestMapper(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Order fromDto(OrderRequestDto dto) {
        Order order = new Order();
        order.setUser(userService.get(dto.getUserId()));
        order.setOrderDate(dto.getOrderDate());
        return null;
    }
}
