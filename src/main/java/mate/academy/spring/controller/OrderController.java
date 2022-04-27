package mate.academy.spring.controller;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.mapper.impl.response.OrderResponseDtoMapper;
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
    private OrderService orderService;
    private UserService userService;
    private ShoppingCartService shoppingCartService;
    private DtoResponseMapper<OrderResponseDto, Order> mapper;

    public OrderController(OrderService orderService,
                           UserService userService, ShoppingCartService shoppingCartService,
                           OrderResponseDtoMapper mapper) {
        this.orderService = orderService;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<OrderResponseDto> getOrderHistory(@RequestParam @Valid Long userId) {
        return orderService.getOrdersHistory(userService.get(userId)).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/complete")
    public OrderResponseDto orderComplete(@RequestParam Long userId) {
        return mapper.toDto(orderService.completeOrder(shoppingCartService
                .getByUser(userService.get(userId))));
    }
}
