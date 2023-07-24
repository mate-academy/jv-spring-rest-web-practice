package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.impl.response.OrderResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final ShoppingCartService shoppingCartService;
    private final OrderResponseMapper orderResponseMapper;
    private final OrderService orderService;

    public OrderController(ShoppingCartService shoppingCartService, OrderResponseMapper orderResponseMapper, OrderService orderService) {
        this.shoppingCartService = shoppingCartService;
        this.orderResponseMapper = orderResponseMapper;
        this.orderService = orderService;
    }


    @PostMapping("/complete")
    public OrderResponseDto complete(@RequestParam Long userId) {
        User user = new User();
        user.setId(userId);
        ShoppingCart scByUser = shoppingCartService.getByUser(user);
        Order orderFromDB = orderService.completeOrder(scByUser);
        return orderResponseMapper.toDto(orderFromDB);
    }

    @GetMapping
    public List<OrderResponseDto> getAll(@RequestParam Long userId) {
        User user = new User();
        user.setId(userId);
        return orderService.getOrdersHistory(user).stream()
                .map(orderResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
