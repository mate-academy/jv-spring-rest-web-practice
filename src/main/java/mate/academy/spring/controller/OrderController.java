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
    private final UserService userService;
    private final OrderResponseMapper orderMapper;
    private final ShoppingCartService shoppingCartService;

    public OrderController(OrderService orderService,
                           UserService userService,
                           OrderResponseMapper orderMapper,
                           ShoppingCartService shoppingCartService) {
        this.orderService = orderService;
        this.userService = userService;
        this.orderMapper = orderMapper;
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/complete")
    public OrderResponseDto complete(@RequestParam Long userId) {
        ShoppingCart shoppingCart = shoppingCartService.getByUser(userService.get(userId));
        Order order = orderService.completeOrder(shoppingCart);
        return orderMapper.modelToDto(order);
    }

    @GetMapping
    public List<OrderResponseDto> getOrders(@RequestParam Long userId) {
        List<Order> orders = orderService.getOrdersHistory(userService.get(userId));
        return orders.stream()
                .map(orderMapper::modelToDto)
                .collect(Collectors.toList());
    }
}
