package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.impl.request.OrderRequestMapper;
import mate.academy.spring.mapper.impl.response.OrderResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.ShoppingCart;
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
    private final OrderRequestMapper requestMapper;
    private final OrderResponseMapper responseMapper;
    private final ShoppingCartService shoppingCartService;

    public OrderController(OrderService orderService, OrderRequestMapper requestMapper,
                           OrderResponseMapper responseMapper,
                           ShoppingCartService shoppingCartService) {
        this.orderService = orderService;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(@RequestParam Long userId) {
        ShoppingCart shoppingCart = shoppingCartService.getByUser(new User(userId));
        Order order = orderService.completeOrder(shoppingCart);
        return responseMapper.toDto(order);
    }

    @GetMapping()
    public List<OrderResponseDto> getAllOrdersHistoryByUser(@RequestParam Long userId) {
        List<Order> ordersHistory = orderService.getOrdersHistory(new User(userId));
        return ordersHistory.stream()
                .map(responseMapper::toDto)
                .collect(Collectors.toList());
    }
}
