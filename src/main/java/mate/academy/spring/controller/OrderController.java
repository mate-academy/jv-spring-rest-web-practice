package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
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
    private UserService userService;
    private ShoppingCartService shoppingCartService;
    private OrderService orderService;
    private DtoResponseMapper<OrderResponseDto, Order> orderResponseDtoMapper;

    public OrderController(UserService userService,
                           ShoppingCartService shoppingCartService,
                           OrderService orderService,
                           DtoResponseMapper<OrderResponseDto, Order> orderResponseDtoMapper) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.orderService = orderService;
        this.orderResponseDtoMapper = orderResponseDtoMapper;
    }

    @PostMapping("/orders/complete")
    public OrderResponseDto completeUserOrder(@RequestParam Long userId) {
        return orderResponseDtoMapper.toDto(
                orderService.completeOrder(
                        shoppingCartService.getByUser(
                                userService.get(userId))));
    }

    @GetMapping("/orders")
    public List<OrderResponseDto> getOrdersByUserId(@RequestParam Long userId) {
        return orderService.getOrdersHistory(userService.get(userId)).stream()
                .map(order -> orderResponseDtoMapper.toDto(order))
                .collect(Collectors.toList());
    }
}
