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
    private OrderService orderService;
    private UserService userService;
    private ShoppingCartService shoppingCartService;
    private DtoResponseMapper<OrderResponseDto, Order> dtoResponseMapper;

    public OrderController(OrderService orderService,
                           UserService userService,
                           ShoppingCartService shoppingCartService,
                           DtoResponseMapper<OrderResponseDto, Order> dtoResponseMapper) {
        this.orderService = orderService;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.dtoResponseMapper = dtoResponseMapper;
    }

    @PostMapping("/complete")
    public void complete(@RequestParam Long userId) {
        orderService.completeOrder(shoppingCartService.getByUser(userService.get(userId)));
    }

    @GetMapping
    public List<OrderResponseDto> ordersHistory(@RequestParam Long userId) {
        List<Order> orders = orderService.getOrdersHistory(userService.get(userId));
        return orders.stream()
                .map(dtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
