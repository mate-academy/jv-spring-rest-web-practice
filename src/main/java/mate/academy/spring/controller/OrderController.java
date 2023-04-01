package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.ShoppingCart;
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
    private final UserService userService;
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;
    private final DtoResponseMapper<OrderResponseDto, Order> orderDtoResponseMapper;

    public OrderController(UserService userService, OrderService orderService,
                           ShoppingCartService shoppingCartService,
                           DtoResponseMapper<OrderResponseDto, Order> orderDtoResponseMapper) {
        this.userService = userService;
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.orderDtoResponseMapper = orderDtoResponseMapper;
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(@RequestParam Long userId) {
        ShoppingCart shoppingCartFromDb = shoppingCartService.getByUser(userService.get(userId));
        Order orderFromDb = orderService.completeOrder(shoppingCartFromDb);
        return orderDtoResponseMapper.toDto(orderFromDb);
    }

    @GetMapping
    public List<OrderResponseDto> getOrders(@RequestParam Long userId) {
        List<Order> ordersFromDb = orderService.getOrdersHistory(userService.get(userId));
        return ordersFromDb.stream()
                .map(orderDtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
