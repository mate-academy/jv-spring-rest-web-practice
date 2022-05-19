package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.impl.response.OrderDtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final OrderService orderService;
    private final OrderDtoResponseMapper orderDtoResponseMapper;

    @Autowired
    public OrderController(ShoppingCartService shoppingCartService, UserService userService,
                           OrderService orderService,
                           OrderDtoResponseMapper orderDtoResponseMapper) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.orderService = orderService;

        this.orderDtoResponseMapper = orderDtoResponseMapper;
    }

    @GetMapping
    public List<OrderResponseDto> getOrdersHistory(@RequestParam Long userId) {
        List<Order> ordersHistory = orderService.getOrdersHistory(userService.get(userId));
        return ordersHistory
                .stream()
                .map(orderDtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(@RequestParam Long userId) {
        ShoppingCart shoppingCart = shoppingCartService.getByUser(userService.get(userId));
        return orderDtoResponseMapper.toDto(orderService.completeOrder(shoppingCart));
    }
}
