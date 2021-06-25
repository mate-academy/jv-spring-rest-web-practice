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
import mate.academy.spring.service.dto.mapping.impl.response.OrderResponseDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final OrderResponseDtoMapper orderResponseDtoMapper;

    public OrderController(OrderService orderService, UserService userService,
                           ShoppingCartService shoppingCartService,
                           OrderResponseDtoMapper orderResponseDtoMapper) {
        this.orderResponseDtoMapper = orderResponseDtoMapper;
        this.orderService = orderService;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(@RequestParam Long userId) {
        User user = userService.findById(userId);
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        Order order = orderService.completeOrder(shoppingCart);
        return orderResponseDtoMapper.toDto(order);
    }

    @GetMapping
    public List<OrderResponseDto> getOrderHistory(@RequestParam Long userId) {
        User user = userService.findById(userId);
        List<Order> orderHistory = orderService.getOrdersHistory(user);
        return orderHistory.stream()
                .map(orderResponseDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
