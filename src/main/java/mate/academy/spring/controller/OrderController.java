package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.impl.response.OrderResponseDtoMapper;
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
    private UserService userService;
    private ShoppingCartService shoppingCartService;
    private OrderService orderService;
    private OrderResponseDtoMapper orderResponseDtoMapper;

    public OrderController(UserService userService, ShoppingCartService shoppingCartService,
                           OrderService orderService,
                           OrderResponseDtoMapper orderResponseDtoMapper) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.orderService = orderService;
        this.orderResponseDtoMapper = orderResponseDtoMapper;
    }

    @PostMapping("/complete")
    public Order complete(@RequestParam Long userId) {
        ShoppingCart shoppingCartServiceByUser =
                shoppingCartService.getByUser(userService.get(userId));
        return orderService.completeOrder(shoppingCartServiceByUser);
    }

    @GetMapping
    public List<OrderResponseDto> getHistoryByUser(@RequestParam Long userId) {
        List<Order> ordersHistorys = orderService.getOrdersHistory(userService.get(userId));
        return ordersHistorys.stream()
                .map(o -> orderResponseDtoMapper.toDto(o))
                .collect(Collectors.toList());
    }
}
