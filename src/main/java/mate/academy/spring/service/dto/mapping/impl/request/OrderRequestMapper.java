package mate.academy.spring.service.dto.mapping.impl.request;

import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderRequestMapper implements DtoRequestMapper<OrderRequestDto, Order> {
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    public OrderRequestMapper(ShoppingCartService shoppingCartService,
                              UserService userService) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }

    public Order fromDto(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        order.setOrderDate(orderRequestDto.getOrderDate());
        order.setTickets(shoppingCartService.getByUser(userService
                .findByEmail(orderRequestDto.getUserEmail())
                .get()).getTickets());
        order.setUser(userService
                .findByEmail(orderRequestDto.getUserEmail()).get());
        return order;
    }
}
