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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;
    private DtoResponseMapper<OrderResponseDto, Order> mapper;
    private ShoppingCartService shoppingCartService;
    private UserService userService;

    public OrderController(OrderService orderService,
                           DtoResponseMapper<OrderResponseDto, Order> mapper,
                           ShoppingCartService shoppingCartService,
                           UserService userService) {
        this.orderService = orderService;
        this.mapper = mapper;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }

    @GetMapping
    public List<OrderResponseDto> getOrdersHistory(@RequestParam Long userId) {
        return orderService.getOrdersHistory(userService.get(userId)).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(@RequestParam Long userId) {
        ShoppingCart byUser = shoppingCartService.getByUser(userService.get(userId));
        return mapper.toDto(orderService.completeOrder(byUser));
    }
}
