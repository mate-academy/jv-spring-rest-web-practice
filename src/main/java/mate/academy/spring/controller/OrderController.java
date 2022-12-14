package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final ShoppingCartService cartService;
    private final UserService userService;
    private final DtoResponseMapper<OrderResponseDto, Order> dtoResponseMapper;

    @Autowired
    public OrderController(OrderService orderService,
                           ShoppingCartService cartService,
                           UserService userService,
                           DtoResponseMapper<OrderResponseDto, Order> dtoResponseMapper) {
        this.orderService = orderService;
        this.cartService = cartService;
        this.userService = userService;
        this.dtoResponseMapper = dtoResponseMapper;
    }

    @PostMapping("/complete/{userId}")
    public OrderResponseDto complete(@PathVariable Long userId) {
        return dtoResponseMapper.toDto(orderService.completeOrder(
                cartService.getByUser(userService.get(userId))));
    }

    @GetMapping("/{userId}")
    public List<OrderResponseDto> get(@PathVariable Long userId) {
        List<Order> ordersHistory = orderService.getOrdersHistory(userService.get(userId));
        return ordersHistory.stream()
                .map(dtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
