package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
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
    private final OrderService orderService;
    private final DtoResponseMapper<OrderResponseDto, Order> mapper;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    public OrderController(OrderService orderService,
                           DtoResponseMapper<OrderResponseDto, Order> mapper,
                           ShoppingCartService shoppingCartService, UserService userService) {
        this.orderService = orderService;
        this.mapper = mapper;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }

    @PostMapping("/complete")
    public OrderResponseDto complete(@RequestParam Long userId) {
        User user = userService.get(userId);
        ShoppingCart cart = shoppingCartService.getByUser(user);
        return mapper.toDto(orderService.completeOrder(cart));
    }

    @GetMapping
    public List<OrderResponseDto> getByUserId(@RequestParam Long userId) {
        User user = userService.get(userId);
        return orderService.getOrdersHistory(user).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
