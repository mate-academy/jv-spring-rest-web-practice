package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.mapper.impl.response.OrderResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final DtoRequestMapper<OrderRequestDto, Order> orderRequestMapper;
    private final DtoResponseMapper<OrderResponseDto, Order> orderResponseMapper;

    public OrderController(OrderService orderService,
                           ShoppingCartService shoppingCartService,
                           UserService userService,
                           DtoRequestMapper<OrderRequestDto, Order> orderRequestMapper,
                           DtoResponseMapper<OrderResponseDto, Order> orderResponseMapper) {
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.orderRequestMapper = orderRequestMapper;
        this.orderResponseMapper = orderResponseMapper;
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(@RequestParam Long userId) {
        return orderResponseMapper.toDto(
                orderService.completeOrder(
                        shoppingCartService.getByUser(userService.get(userId))));
    }

    @GetMapping
    public List<OrderResponseDto> getOrdersHistory(@RequestParam Long userId) {
        return orderService.getOrdersHistory(userService.get(userId)).stream()
                .map(orderResponseMapper::toDto)
                .collect(Collectors.toList());
    }


}
