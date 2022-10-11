package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.OrderResponseDtoMapper;
import mate.academy.spring.model.Order;
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
    private final OrderService orderService;
    private final OrderResponseDtoMapper orderResponseDtoMapper;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    public OrderController(OrderService orderService,
                           OrderResponseDtoMapper orderResponseDtoMapper,
                           ShoppingCartService shoppingCartService,
                           UserService userService) {
        this.orderService = orderService;
        this.orderResponseDtoMapper = orderResponseDtoMapper;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(@RequestParam Long userId) {
        Order order = orderService.completeOrder(
                shoppingCartService.getByUser(userService.get(userId)));
        return orderResponseDtoMapper.toDto(order);
    }

    @GetMapping
    public List<OrderResponseDto> getHistory(@RequestParam Long userId) {
        return orderService.getOrdersHistory(userService.get(userId)).stream()
                .map(orderResponseDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
