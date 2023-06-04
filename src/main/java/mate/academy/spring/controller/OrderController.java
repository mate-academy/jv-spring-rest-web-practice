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
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final OrderService orderService;
    private final DtoResponseMapper<OrderResponseDto, Order>
            orderDtoResponseMapper;

    public OrderController(UserService userService, ShoppingCartService shoppingCartService,
                           OrderService orderService,
                           DtoResponseMapper<OrderResponseDto, Order> orderDtoResponseMapper) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.orderService = orderService;
        this.orderDtoResponseMapper = orderDtoResponseMapper;
    }

    @PostMapping("/complete/{userId}")
    public OrderResponseDto complete(@PathVariable Long userId) {
        ShoppingCart cartByUser = shoppingCartService.getByUser(userService.get(userId));
        return orderDtoResponseMapper.toDto(orderService.completeOrder(cartByUser));
    }

    @GetMapping("/{userId}")
    public List<OrderResponseDto> getOrdersHistory(@PathVariable Long userId) {
        return orderService.getOrdersHistory(userService.get(userId)).stream()
                .map(orderDtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
