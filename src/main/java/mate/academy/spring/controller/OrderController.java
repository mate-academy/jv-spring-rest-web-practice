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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/orders")
public class OrderController {
    private UserService userService;
    private ShoppingCartService shoppingCartService;
    private OrderService orderService;
    private DtoResponseMapper<OrderResponseDto, Order> orderDtoResponseMapper;

    public OrderController(UserService userService, ShoppingCartService shoppingCartService,
                           OrderService orderService,
                           DtoResponseMapper<OrderResponseDto, Order> orderDtoResponseMapper) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.orderService = orderService;
        this.orderDtoResponseMapper = orderDtoResponseMapper;
    }

    @PostMapping("/orders/complete")
    public OrderResponseDto completeOrder(@RequestBody Long userId) {
        return orderDtoResponseMapper.toDto(orderService
                .completeOrder(shoppingCartService.getByUser(userService.get(userId))));
    }

    @GetMapping
    public List<OrderResponseDto> getAllOrders(Long userId) {
        return orderService.getOrdersHistory(userService.get(userId))
                .stream()
                .map(orderDtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
