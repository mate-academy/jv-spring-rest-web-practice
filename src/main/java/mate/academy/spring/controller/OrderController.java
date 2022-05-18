package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.impl.response.OrderResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderResponseMapper orderResponseMapper;
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    public OrderController(OrderResponseMapper orderResponseMapperDto,
                           OrderService orderService,
                           ShoppingCartService shoppingCartService,
                           UserService userService) {
        this.orderResponseMapper = orderResponseMapperDto;
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(@RequestParam Long userId) {
        return orderResponseMapper.toDto(orderService.completeOrder(shoppingCartService
                .getByUser(userService.get(userId))));
    }

    @PostMapping
    public List<OrderResponseDto> getOrdersHistory(@RequestParam Long userId) {
        List<Order> orderHistoryList = orderService.getOrdersHistory(userService.get(userId));
        return orderHistoryList.stream()
                .map(orderResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
