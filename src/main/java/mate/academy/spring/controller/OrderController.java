package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.impl.response.OrderResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final ShoppingCartService cartService;
    private final UserService userService;
    private final OrderResponseMapper orderResponseMapper;

    public OrderController(OrderService orderService,
                           ShoppingCartService cartService,
                           UserService userService,
                           OrderResponseMapper orderResponseMapper) {
        this.orderService = orderService;
        this.cartService = cartService;
        this.userService = userService;
        this.orderResponseMapper = orderResponseMapper;
    }

    @PostMapping("/order_complete")
    public OrderResponseDto completeOrder(@RequestParam Long userId) {
        User user = userService.getById(userId);
        ShoppingCart shoppingCart = cartService.getByUser(user);
        Order order = orderService.completeOrder(shoppingCart);
        return orderResponseMapper.toDto(order);
    }

    @GetMapping
    public List<OrderResponseDto> getOrdersHistory(@RequestParam Long userId) {
        User user = userService.getById(userId);
        List<Order> orders = orderService.getOrdersHistory(user);
        return orders.stream()
                .map(orderResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
