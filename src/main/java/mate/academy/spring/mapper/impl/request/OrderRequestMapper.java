package mate.academy.spring.mapper.impl.request;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderRequestMapper implements DtoRequestMapper<OrderRequestDto, Order> {
    private UserService userService;
    private ShoppingCartService shoppingCartService;

    @Autowired
    public OrderRequestMapper(UserService userService,
                              ShoppingCartService shoppingCartService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public Order fromDto(OrderRequestDto dto) {
        Order order = new Order();
        order.setUser(userService.get(dto.getUserId()));
        order.setTickets(
                 shoppingCartService.getByUser(order.getUser()).getTickets()
        );
        order.setOrderDate(dto.getOrderDate());
        return order;
    }
}
