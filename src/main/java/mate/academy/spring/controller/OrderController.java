
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
    private final DtoResponseMapper<OrderResponseDto, Order> orderResponseMapper;
    private final OrderService orderService;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    public OrderController(DtoResponseMapper<OrderResponseDto, Order> orderResponseMapper,
                           OrderService orderService, UserService userService,
                           ShoppingCartService shoppingCartService) {
        this.orderResponseMapper = orderResponseMapper;
        this.orderService = orderService;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/complete")
    public OrderResponseDto add(@RequestParam Long userId) {
        ShoppingCart cart = shoppingCartService.getByUser(userService.get(userId));
        return orderResponseMapper.toDto(orderService.completeOrder(cart));
    }

    @GetMapping
    public List<OrderResponseDto> getOrdersHistory(@RequestParam Long userId) {
        return orderService.getOrdersHistory(userService.get(userId)).stream()
                .map(orderResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
