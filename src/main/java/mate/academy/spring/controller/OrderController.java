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
    private OrderService orderService;
    private UserService userService;
    private ShoppingCartService shoppingCartService;
    private OrderResponseMapper responseMapper;

    public OrderController(OrderService orderService,
                           UserService userService,
                           ShoppingCartService shoppingCartService,
                           OrderResponseMapper responseMapper) {
        this.orderService = orderService;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.responseMapper = responseMapper;
    }

    @GetMapping
    public List<OrderResponseDto> get(@RequestParam Long userId) {
        List<Order> ordersHistory = orderService.getOrdersHistory(userService.get(userId));
        return ordersHistory.stream()
                .map(responseMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public OrderResponseDto completeOrder(@RequestParam Long userId) {
        ShoppingCart shoppingCart = shoppingCartService.getByUser(userService.get(userId));
        return responseMapper.toDto(orderService.completeOrder(shoppingCart));
    }
}
