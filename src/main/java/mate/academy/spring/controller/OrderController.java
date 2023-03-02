package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.response.OrdersResponseDto;
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
    private final DtoResponseMapper<OrdersResponseDto, Order> ordersResponseMapper;
    private final ShoppingCartService shoppingCartService;

    public OrderController(OrderService orderService, UserService userService,
                           DtoResponseMapper<OrdersResponseDto, Order> ordersResponseMapper,
                           ShoppingCartService shoppingCartService) {
        this.orderService = orderService;
        this.userService = userService;
        this.ordersResponseMapper = ordersResponseMapper;
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping
    public List<OrdersResponseDto> getAllOrders(@RequestParam Long userId) {
        return orderService.getOrdersHistory(userService.get(userId))
                .stream()
                .map(ordersResponseMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/complete")
    public OrdersResponseDto completeOrder(@RequestParam Long userId) {
        Order order = orderService.completeOrder(
                shoppingCartService.getByUser(userService.get(userId)));
        return ordersResponseMapper.toDto(order);
    }
}
