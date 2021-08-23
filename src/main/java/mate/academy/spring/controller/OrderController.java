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
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
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
    private final DtoResponseMapper<OrderResponseDto, Order> orderDtoResponseMapper;

    public OrderController(OrderService orderService, UserService userService,
                           ShoppingCartService shoppingCartService,
                           DtoResponseMapper<OrderResponseDto, Order> orderDtoResponseMapper) {
        this.orderService = orderService;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.orderDtoResponseMapper = orderDtoResponseMapper;
    }

    @GetMapping
    public List<OrderResponseDto> getAllOrders(@RequestParam Long userId) {
        User user = userService.findById(userId).get();
        return orderService.getOrdersHistory(user).stream()
                .map(orderDtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public OrderResponseDto completeOrder(@RequestParam Long userId) {
        ShoppingCart shoppingCart = shoppingCartService
                .getByUser(userService.findById(userId).get());
        return orderDtoResponseMapper.toDto(orderService.completeOrder(shoppingCart));
    }
}
