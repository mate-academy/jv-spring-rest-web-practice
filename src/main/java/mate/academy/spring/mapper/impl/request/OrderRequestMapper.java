package mate.academy.spring.mapper.impl.request;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class OrderRequestMapper implements DtoRequestMapper<OrderRequestDto, Order> {
    private final OrderService orderService;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    public OrderRequestMapper(OrderService orderService, UserService userService,
                              ShoppingCartService shoppingCartService) {
        this.orderService = orderService;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public Order fromDto(OrderRequestDto dto) {
        Order order = new Order();
        order.setOrderDate(dto.getOrderDate());
        order.setUser(userService.get(dto.getUserId()));
        order.setTickets(shoppingCartService
                .getByUser(order.getUser())
                .getTickets());
        return order;
    }
}
