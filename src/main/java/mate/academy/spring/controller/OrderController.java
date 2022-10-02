package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.impl.response.OrderResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/orders")
public class OrderController {
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final OrderResponseMapper orderResponseMapper;

    public OrderController(OrderService orderService,
                           ShoppingCartService shoppingCartService,
                           UserService userService, OrderResponseMapper orderResponseMapper) {
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.orderResponseMapper = orderResponseMapper;
    }

    @PostMapping("/complete")
    public OrderResponseDto update(@RequestParam Long id) {
        User user = userService.get(id);
        ShoppingCart cartByUser = shoppingCartService.getByUser(user);
        Order completeOrder = orderService.completeOrder(cartByUser);
        return orderResponseMapper.toDto(completeOrder);
    }

    @GetMapping
    public List<OrderResponseDto> get(@RequestParam Long id) {
        User user = userService.get(id);
        List<Order> ordersHistory = orderService.getOrdersHistory(user);
        return ordersHistory
                .stream()
                .map(orderResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
