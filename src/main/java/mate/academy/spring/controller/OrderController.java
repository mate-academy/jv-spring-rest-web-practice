package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    public OrderController(OrderService orderService,
                           UserService userService, ShoppingCartService shoppingCartService,
                           DtoResponseMapper<OrderResponseDto, Order> orderDtoResponse) {
        this.orderService = orderService;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.orderDtoResponseMapper = orderDtoResponse;
    }

    @PostMapping("/complete")
    public OrderResponseDto add(@RequestParam Long userId) {
        User user = userService.get(userId);
        Order order = orderService.completeOrder(shoppingCartService.getByUser(user));
        return orderDtoResponseMapper.toDto(order);
    }

    @GetMapping
    public List<OrderResponseDto> get(@RequestBody Long userId) {
        return orderService.getOrdersHistory(userService.get(userId)).stream()
                .map(orderDtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
