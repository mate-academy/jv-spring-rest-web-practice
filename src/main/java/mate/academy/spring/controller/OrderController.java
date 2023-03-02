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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
public class OrderController {
    private final UserService userService;
    private final OrderService orderService;
    private final DtoResponseMapper<OrderResponseDto, Order> responseMapper;
    private final ShoppingCartService cartService;

    public OrderController(UserService userService, OrderService orderService,
                           DtoResponseMapper<OrderResponseDto, Order> responseMapper,
                           ShoppingCartService cartService) {
        this.userService = userService;
        this.orderService = orderService;
        this.responseMapper = responseMapper;
        this.cartService = cartService;
    }

    @PostMapping("/complete/{userId}")
    public OrderResponseDto getComplete(@PathVariable Long userId) {
        return responseMapper.toDto(
                orderService.completeOrder(cartService
                        .getByUser(userService.get(userId))));
    }

    @GetMapping("/{userId}")
    public List<OrderResponseDto> get(@PathVariable Long userId) {
        return orderService.getOrdersHistory(userService.get(userId))
                .stream().map(responseMapper::toDto)
                .collect(Collectors.toList());
    }
}
