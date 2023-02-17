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
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/orders")
public class OrderController {
    private final DtoResponseMapper<OrderResponseDto, Order> responseMapper;
    private final UserService userService;
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;

    public OrderController(DtoResponseMapper<OrderResponseDto, Order> responseMapper, UserService userService, OrderService orderService, ShoppingCartService shoppingCartService) {
        this.responseMapper = responseMapper;
        this.userService = userService;
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/complete")
    public OrderResponseDto add(@RequestParam Long userId) {
        User user = userService.get(userId);
        ShoppingCart userShoppingCart = shoppingCartService.getByUser(user);
        Order order = orderService.completeOrder(userShoppingCart);
        return responseMapper.toDto(order);
    }

    @GetMapping()
    public List<OrderResponseDto> getAll(@RequestParam Long userId) {
        return orderService.getOrdersHistory(userService.get(userId)).stream()
                .map(responseMapper::toDto)
                .collect(Collectors.toList());
    }
}
