package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.impl.response.OrderResponseMapper;
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
    private final ShoppingCartService cartService;
    private final OrderResponseMapper responseMapper;

    public OrderController(UserService userService, OrderService orderService,
                           ShoppingCartService cartService, OrderResponseMapper responseMapper) {
        this.userService = userService;
        this.orderService = orderService;
        this.cartService = cartService;
        this.responseMapper = responseMapper;
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(@RequestParam Long userId) {
        Order order = orderService.completeOrder(cartService.getByUser(userService.get(userId)));
        return responseMapper.parseToDto(order);
    }

    @GetMapping
    public List<OrderResponseDto> getOrdersHistory(@RequestParam Long userId) {
        return orderService.getOrdersHistory(userService.get(userId)).stream()
                .map(responseMapper::parseToDto)
                .collect(Collectors.toList());
    }
}
