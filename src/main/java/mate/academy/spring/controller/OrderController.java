package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.impl.response.OrderResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final OrderResponseMapper orderResponseMapper;

    public OrderController(OrderService orderService,
                           ShoppingCartService shoppingCartService, UserService userService,
                           OrderResponseMapper orderResponseMapper) {
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.orderResponseMapper = orderResponseMapper;
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(@RequestParam Long userId) {
        ShoppingCart currentCart = shoppingCartService.getByUser(userService.get(userId));
        return orderResponseMapper.toDto(orderService.completeOrder(currentCart));
    }

    @GetMapping
    public List<OrderResponseDto> getOrdersHistory(@RequestParam Long userId) {
        List<Order> ordersHistory = orderService.getOrdersHistory(userService.get(userId));
        return ordersHistory.stream()
                .map(orderResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
