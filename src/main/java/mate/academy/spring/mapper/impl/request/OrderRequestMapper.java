package mate.academy.spring.mapper.impl.request;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderRequestMapper implements DtoRequestMapper<OrderRequestDto, Order> {
    @Autowired
    private UserService userService;
    @Autowired
    private ShoppingCartService shoppingCartService;

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
