package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.impl.response.OrderResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final OrderResponseMapper orderResponseMapper;
    private final OrderService orderService;

    public OrderController(ShoppingCartService shoppingCartService,
                           UserService userService,
                           OrderResponseMapper orderResponseMapper,
                           OrderService orderService) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.orderResponseMapper = orderResponseMapper;
        this.orderService = orderService;
    }

    @PutMapping("/complete")
    public OrderResponseDto completeOrder(@RequestParam Long userId) {
        return orderResponseMapper
                .toDto(orderService
                        .completeOrder(shoppingCartService
                                .getByUser(userService.getById(userId))));
    }

    @GetMapping
    public List<Long> getOrderHistory(@RequestParam Long userId) {
        return orderService.getOrdersHistory(userService.getById(userId))
                .stream()
                .mapToLong(Order::getId)
                .boxed()
                .collect(Collectors.toList());
    }
}
