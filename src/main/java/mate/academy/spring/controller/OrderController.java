package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.impl.response.OrderResponseMapper;
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
    private final OrderResponseMapper orderResponseMapper;
    private final ShoppingCartService shoppingCartService;
    private final OrderService orderService;
    private final UserService userService;

    public OrderController(OrderResponseMapper orderResponseMapper,
                           ShoppingCartService shoppingCartService,
                           OrderService orderService,
                           UserService userService) {
        this.orderResponseMapper = orderResponseMapper;
        this.shoppingCartService = shoppingCartService;
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/")
    public List<OrderResponseDto> getOrdersHistory(@RequestParam Long userId) {
        return orderService.getOrdersHistory(userService.get(userId))
                .stream()
                .map(orderResponseMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(@RequestParam Long userId) {
        ShoppingCart shoppingCart = shoppingCartService.getByUser(userService.get(userId));
        return orderResponseMapper.toDto(orderService.completeOrder(shoppingCart));
    }
}
