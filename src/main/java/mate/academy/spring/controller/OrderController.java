package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.impl.request.OrderRequestMapper;
import mate.academy.spring.service.dto.mapping.impl.response.OrderResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderResponseMapper responseMapper;
    private final UserService userService;

    public OrderController(OrderService orderService, OrderResponseMapper responseMapper,
                           OrderRequestMapper requestMapper, UserService userService) {
        this.orderService = orderService;
        this.responseMapper = responseMapper;
        this.userService = userService;
    }

    @PostMapping("/complete")
    public void complete(@RequestParam Long userId) {
        orderService.completeOrder(orderService.getShoppingCartByUserId(userId));
    }

    @GetMapping
    public List<OrderResponseDto> getHistoryByUser(@RequestParam Long userId) {
        return orderService.getOrdersHistory(userService.findById(userId).get())
                .stream()
                .map(responseMapper::toDto)
                .collect(Collectors.toList());
    }
}
