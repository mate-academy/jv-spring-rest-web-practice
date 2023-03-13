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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final DtoResponseMapper<OrderResponseDto, Order> dtoResponseMapper;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    public OrderController(OrderService orderService,
                           DtoResponseMapper<OrderResponseDto, Order> dtoResponseMapper,
                           UserService userService, ShoppingCartService shoppingCartService) {
        this.orderService = orderService;
        this.dtoResponseMapper = dtoResponseMapper;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/complete")
    public OrderResponseDto complete(@PathVariable Long userId) {
        ShoppingCart byUser = shoppingCartService.getByUser(userService.get(userId));
        return dtoResponseMapper.toDto(orderService.completeOrder(byUser));
    }

    @GetMapping
    public List<OrderResponseDto> getAllOrders(@PathVariable Long userId) {
        return orderService.getOrdersHistory(userService.get(userId)).stream()
                .map(dtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
