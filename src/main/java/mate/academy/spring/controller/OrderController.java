package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.impl.response.OrderResponseMapper;
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
    private final OrderService orderService;
    private final ShoppingCartService cartService;
    private final UserService userService;
    private final OrderResponseMapper orderResponseMapper;

    @Autowired
    public OrderController(OrderService orderService,
                           ShoppingCartService cartService,
                           UserService userService,
                           OrderResponseMapper orderResponseMapper) {
        this.orderService = orderService;
        this.cartService = cartService;
        this.userService = userService;
        this.orderResponseMapper = orderResponseMapper;
    }

    @PostMapping("/orders/complete")
    public void complete(@RequestParam Long userId) {
        orderService.completeOrder(cartService.getByUser(userService.get(userId)));
    }

    @GetMapping("/orders")
    public List<OrderResponseDto> getOrderHistory(@RequestParam Long userId) {
        return orderService.getOrdersHistory(userService.get(userId)).stream()
                .map(orderResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
