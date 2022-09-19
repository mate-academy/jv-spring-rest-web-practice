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
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final DtoResponseMapper<OrderResponseDto, Order> orderResponseMapper;

    public OrderController(
            OrderService orderService,
            ShoppingCartService shoppingCartService,
            UserService userService,
            DtoResponseMapper<OrderResponseDto, Order> dtoResponseMapper) {
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.orderResponseMapper = dtoResponseMapper;
    }

    @PostMapping("/complete")
    public OrderResponseDto complete(@RequestParam Long id) {
        User user = userService.get(id);
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        return orderResponseMapper.toDto(orderService.completeOrder(shoppingCart));
    }

    @GetMapping
    public List<OrderResponseDto> getOrdersHistory(@RequestParam Long id) {
        return orderService.getOrdersHistory(userService.get(id)).stream()
                .map(orderResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
