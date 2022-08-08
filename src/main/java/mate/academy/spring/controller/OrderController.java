package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
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
    private OrderService orderService;
    private ShoppingCartService shoppingCartService;
    private final DtoResponseMapper<OrderResponseDto, Order> orderDtoResponseMapper;

    public OrderController(UserService userService, OrderService orderService,
                           ShoppingCartService shoppingCartService,
                           DtoResponseMapper<OrderResponseDto, Order> orderDtoResponseMapper) {
        this.userService = userService;
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.orderDtoResponseMapper = orderDtoResponseMapper;
    }

    @PostMapping("/complete")
    public void complete(@RequestParam Long userId) {
        orderService.completeOrder(shoppingCartService.getByUser(userService.get(userId)));
    }

    @GetMapping
    @RequestMapping
    public List<OrderResponseDto> getOrdersHistory(@RequestParam Long userId) {
        return orderService.getOrdersHistory(userService.get(userId)).stream()
                .map(orderDtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
