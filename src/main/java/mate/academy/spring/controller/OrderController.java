package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
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
    private OrderService orderService;
    private OrderResponseMapper mapper;
    private ShoppingCartService shoppingCartService;
    private UserService userService;

    public OrderController(OrderService orderService,
                           OrderResponseMapper mapper,
                           ShoppingCartService shoppingCartService,
                           UserService userService) {
        this.orderService = orderService;
        this.mapper = mapper;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }

    @PostMapping("/complete")
    public OrderResponseDto complete(@RequestParam long userId) {
        return mapper.toDto(orderService.completeOrder(shoppingCartService
                .getByUser(userService.get(userId))));
    }

    @GetMapping
    public List<OrderResponseDto> getOrdersById(@RequestParam long userId) {
        return orderService.getOrdersHistory(userService.get(userId)).stream()
                .map(mapper::toDto).collect(Collectors.toList());
    }

}
