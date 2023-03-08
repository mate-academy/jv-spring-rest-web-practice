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
    private final OrderService orderService;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final DtoResponseMapper<OrderResponseDto, Order>
            movieSessionDtoResponseMapper;

    public OrderController(
            OrderService orderService,
            UserService userService,
            ShoppingCartService shoppingCartService,
            DtoResponseMapper<OrderResponseDto, Order> movieSessionDtoResponseMapper
    ) {
        this.orderService = orderService;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.movieSessionDtoResponseMapper = movieSessionDtoResponseMapper;
    }

    @GetMapping
    public List<OrderResponseDto> getByUserId(@RequestParam Long userId) {
        return orderService.getOrdersHistory(userService.get(userId))
                .stream()
                .map(movieSessionDtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public OrderResponseDto create(@RequestParam Long userId) {
        ShoppingCart userShoppingCart = shoppingCartService.getByUser(userService.get(userId));
        Order order = orderService.completeOrder(userShoppingCart);
        return movieSessionDtoResponseMapper.toDto(order);
    }
}
