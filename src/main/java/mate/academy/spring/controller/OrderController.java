package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.impl.request.OrderRequestMapper;
import mate.academy.spring.service.dto.mapping.impl.response.OrderResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final UserService userService;
    private final OrderService orderService;
    private final OrderResponseMapper orderResponseMapper;
    private final OrderRequestMapper orderRequestMapper;
    private final ShoppingCartService shoppingCartService;

    public OrderController(UserService userService,
                   OrderService orderService, OrderResponseMapper orderResponseMapper,
                   OrderRequestMapper orderRequestMapper, ShoppingCartService shoppingCartService) {
        this.userService = userService;
        this.orderService = orderService;
        this.orderResponseMapper = orderResponseMapper;
        this.orderRequestMapper = orderRequestMapper;
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping
    public List<OrderResponseDto> getByUser(@RequestParam Long userId) {
        User user = userService.get(userId);
        List<Order> orders = orderService.getOrdersHistory(user);
        return orders.stream().map(orderResponseMapper::toDto).collect(Collectors.toList());
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(@RequestParam Long userId,
                      @RequestBody OrderRequestDto orderRequestDto) {
        Order order = orderRequestMapper.fromDto(orderRequestDto);
        order.setUser(userService.get(userId));
        Order completeOrder = orderService.completeOrder(
                shoppingCartService.getByUser(userService.get(userId)));
        return orderResponseMapper.toDto(completeOrder);
    }
}
