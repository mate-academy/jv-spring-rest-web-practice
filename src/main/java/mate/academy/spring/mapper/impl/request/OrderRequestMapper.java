package mate.academy.spring.mapper.impl.request;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
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
        order.setTickets(shoppingCartService
                .getByUser(userService.get(dto.getUserId())).getTickets());
        order.setOrderDate(dto.getOrderDate());
        order.setUser(userService.get(dto.getUserId()));
        return order;
    }
}
