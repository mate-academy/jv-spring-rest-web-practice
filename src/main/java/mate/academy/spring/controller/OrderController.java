package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.impl.response.OrderResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;
    private OrderResponseMapper orderResponseMapper;
    private ShoppingCartService shoppingCartService;
    private UserService userService;

    @Autowired
    public OrderController(OrderService orderService,
            OrderResponseMapper orderResponseMapper,
            ShoppingCartService shoppingCartService,
            UserService userService) {
        this.orderService = orderService;
        this.orderResponseMapper = orderResponseMapper;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(@RequestParam Long userId) {
        return orderResponseMapper.toDto(
                orderService.completeOrder(
                        shoppingCartService.getByUser(userService.get(userId))));
    }

    @GetMapping
    public List<OrderResponseDto> getAllByUser(@RequestParam Long userId) {
        return orderService.getOrdersHistory(userService.get(userId)).stream()
                .map(orderResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
