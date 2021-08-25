package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final UserService userService;
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;
    private final DtoRequestMapper<OrderRequestDto, Order>
            orderDtoRequestMapper;
    private final DtoResponseMapper<OrderResponseDto, Order>
            orderDtoResponseMapper;

    public OrderController(UserService userService,
            OrderService orderService,
            ShoppingCartService shoppingCartService,
            DtoRequestMapper<OrderRequestDto, Order> orderDtoRequestMapper,
            DtoResponseMapper<OrderResponseDto, Order> orderDtoResponseMapper) {
        this.userService = userService;
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.orderDtoRequestMapper = orderDtoRequestMapper;
        this.orderDtoResponseMapper = orderDtoResponseMapper;
    }

    @GetMapping
    public List<OrderResponseDto> complate(@PathVariable Long userId) {
        return orderService.getOrdersHistory(userService.findById(userId).get()).stream()
                .map(orderDtoResponseMapper::toDto).collect(
                        Collectors.toList());
    }

    @PostMapping("/complate")
    public OrderResponseDto compateOrder(@RequestParam Long id) {
        return orderDtoResponseMapper.toDto(orderService
                .completeOrder(shoppingCartService.getByUser(userService.findById(id).get())));
    }
}
