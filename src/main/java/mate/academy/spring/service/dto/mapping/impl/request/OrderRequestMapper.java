package mate.academy.spring.service.dto.mapping.impl.request;

import mate.academy.spring.model.Order;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderRequestMapper implements DtoRequestMapper<OrderRequestDto, Order> {
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    public OrderRequestMapper(ShoppingCartService shoppingCartService, UserService userService) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }

    @Override
    public Order fromDto(OrderRequestDto dto) {
        Order order = new Order();
        User user = userService.get(dto.getUserId());
        order.setUser(user);
        order.setTickets(shoppingCartService.getByUser(user).getTickets());
        order.setOrderDate(dto.getOrderDate());
        return order;
    }
}
