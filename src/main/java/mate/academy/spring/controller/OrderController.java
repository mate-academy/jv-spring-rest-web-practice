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
    private final DtoResponseMapper<OrderResponseDto, Order> orderDtoResponseMapper;
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    public OrderController(DtoResponseMapper<OrderResponseDto, Order> orderDtoResponseMapper,
                           OrderService orderService,
                           ShoppingCartService shoppingCartService,
                           UserService userService) {
        this.orderDtoResponseMapper = orderDtoResponseMapper;
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }

    @PostMapping("/complete")
    public OrderResponseDto complete(@RequestParam Long userId) {
        return orderDtoResponseMapper.toDto(orderService.completeOrder(
                shoppingCartService.getByUser(userService.get(userId))));
    }

    @GetMapping("/by-user")
    public List<OrderResponseDto> getOrdersHistoryForUser(@RequestParam Long userId) {
        return orderService.getOrdersHistory(userService.get(userId)).stream()
                .map(orderDtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
