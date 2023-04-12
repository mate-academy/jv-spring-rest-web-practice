package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.UserResponseDto;
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
    private final DtoResponseMapper<UserResponseDto, User> responseMapper;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    public OrderController(OrderService orderService,
                           DtoResponseMapper<UserResponseDto, User> responseMapper,
                           ShoppingCartService shoppingCartService, UserService userService) {
        this.orderService = orderService;
        this.responseMapper = responseMapper;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }

    @PostMapping("/complete")
    public UserResponseDto complete(@RequestParam Long userId) {
        Order order = orderService.completeOrder(
                shoppingCartService.getByUser(userService.get(userId)));
        return responseMapper.toDto(order);
    }

    @GetMapping
    public List<UserResponseDto> get(@RequestParam Long userId) {
        User user = userService.get(userId);
        return orderService.getOrdersHistory(user)
                .stream()
                .map(responseMapper::toDto)
                .collect(Collectors.toList());
    }
}
