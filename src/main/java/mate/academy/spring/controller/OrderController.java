package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.impl.response.OrderResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderResponseMapper orderResponseMapper;
    private final ShoppingCartService shoppingCartService;

    public OrderController(OrderService orderService,
                           OrderResponseMapper orderResponseMapper,
                           ShoppingCartService shoppingCartService) {
        this.orderService = orderService;
        this.orderResponseMapper = orderResponseMapper;
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/complete")
    public OrderResponseDto complete(@RequestParam Long userId) {
        User user = new User();
        user.setId(userId);
        return orderResponseMapper.toDto(orderService
                .completeOrder(shoppingCartService
                        .getByUser(user)));
    }

    @GetMapping
    public List<OrderResponseDto> getOrdersHistory(@RequestParam Long userId) {
        User user = new User();
        user.setId(userId);
        return orderService.getOrdersHistory(user).stream()
                .map(orderResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
