package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.mapper.impl.response.OrderResponseMapper;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.CinemaHallResponseDto;
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
    private ShoppingCartService cartService;
    private OrderService orderService;
    private DtoResponseMapper<OrderResponseDto,
            Order> responseMapper;

    public OrderController(UserService userService,
                           ShoppingCartService cartService,
                           OrderService orderService, DtoResponseMapper<OrderResponseDto,
            Order> responseMapper) {
        this.userService = userService;
        this.cartService = cartService;
        this.orderService = orderService;
        this.responseMapper = responseMapper;
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(@RequestParam Long userId) {
        User user = userService.get(userId);
        ShoppingCart shoppingCart = cartService.getByUser(user);
        return responseMapper.toDto(orderService.completeOrder(shoppingCart));
    }

    @GetMapping
    public List<OrderResponseDto> getOrdersHistoryByUser(@RequestParam Long userId) {
        User user = userService.get(userId);
        return orderService.getOrdersHistory(user).stream()
                .map(responseMapper::toDto)
                .collect(Collectors.toList());
    }
}
