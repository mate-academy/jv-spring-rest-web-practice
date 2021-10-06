package mate.academy.spring.service.dto.mapping.impl.request;

import java.util.List;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderRequestMapper implements DtoRequestMapper<OrderRequestDto, Order> {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    public OrderRequestMapper(UserService userService, ShoppingCartService shoppingCartService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public Order fromDto(OrderRequestDto dto) {
        Order order = new Order();
        User user = userService.get(dto.getUserId());
        List<Ticket> tickets = shoppingCartService.getByUser(user).getTickets();
        order.setOrderDate(dto.getOrderDate());
        order.setTickets(tickets);
        order.setUser(user);
        return order;
    }
}
