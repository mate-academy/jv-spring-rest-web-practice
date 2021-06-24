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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderResponseMapper orderResponseMapper;
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    public OrderController(OrderResponseMapper orderResponseMapper, OrderService orderService,
                           ShoppingCartService shoppingCartService, UserService userService) {
        this.orderResponseMapper = orderResponseMapper;
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(@RequestParam Long userId) {
        Order order = orderService.completeOrder(shoppingCartService.getByUser(userService
                .get(userId)));
        return orderResponseMapper.toDto(order);
    }

    @GetMapping
    public List<OrderResponseDto> getOrdersHistoryForUser(@RequestParam Long id) {
        return orderService.getOrdersHistory(userService.get(id))
                .stream().map(orderResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
