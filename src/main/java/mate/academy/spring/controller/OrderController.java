package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
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

@RestController
public class OrderController {
    private final DtoResponseMapper<OrderResponseDto, Order> orderDtoResponseMapper;
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    public OrderController(DtoResponseMapper<OrderResponseDto, Order> orderDtoResponseMapper,
                           OrderService orderService,
                           ShoppingCartService shoppingCartService,
                           UserService userService) {
        this.orderDtoResponseMapper = orderDtoResponseMapper;
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }

    @PostMapping("/orders/complete")
    public OrderResponseDto complete(@RequestParam Long userId) {
        User user = userService.get(userId);
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        Order order = orderService.completeOrder(shoppingCart);
        return orderDtoResponseMapper.toDto(order);
    }

    @GetMapping("/orders")
    public List<OrderResponseDto> getOrdersHistoryForUser(@RequestParam Long userId) {
        User user = userService.get(userId);
        return orderService.getOrdersHistory(user).stream()
                .map(orderDtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
