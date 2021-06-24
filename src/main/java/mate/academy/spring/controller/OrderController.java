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
    private final OrderService orderService;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final OrderResponseMapper responseMapper;

    public OrderController(OrderService orderService,
                           UserService userService,
                           ShoppingCartService shoppingCartService,
                           OrderResponseMapper responseMapper) {
        this.orderService = orderService;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.responseMapper = responseMapper;
    }

    @PostMapping("/complete")
    public OrderResponseDto complete(@RequestParam Long userId) {
        return responseMapper.toDto(orderService.completeOrder(
                shoppingCartService.getByUser(userService.getById(userId))));
    }

    @GetMapping
    public List<OrderResponseDto> getOrderHistory(@RequestParam Long userId) {
        return orderService.getOrdersHistory(userService.getById(userId))
                 .stream()
                 .map(responseMapper::toDto)
                 .collect(Collectors.toList());
    }
}
