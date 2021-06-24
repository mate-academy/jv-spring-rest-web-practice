package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final DtoResponseMapper<OrderResponseDto, Order> responseMapper;
    private final ShoppingCartService cartService;
    private final UserService userService;
    private final OrderService orderService;

    public OrderController(DtoResponseMapper<OrderResponseDto, Order> responseMapper,
                           UserService userService, OrderService orderService,
                           ShoppingCartService cartService) {
        this.responseMapper = responseMapper;
        this.userService = userService;
        this.orderService = orderService;
        this.cartService = cartService;
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(@RequestParam Long userId) {
        ShoppingCart shoppingCart = cartService.getByUser(userService.getById(userId));
        return responseMapper.toDto(orderService.completeOrder(shoppingCart));
    }

    @GetMapping
    public List<OrderResponseDto> getHistory(@RequestParam Long userId) {
        User user = userService.getById(userId);
        return orderService.getOrdersHistory(user).stream()
                .map(responseMapper::toDto)
                .collect(Collectors.toList());
    }

}
