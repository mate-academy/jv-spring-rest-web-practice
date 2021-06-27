package mate.academy.spring.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
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
    private final OrderResponseMapper orderResponseMapper;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    
    public OrderController(OrderService orderService, OrderResponseMapper orderResponseMapper,
                           ShoppingCartService shoppingCartService, UserService userService) {
        this.orderService = orderService;
        this.orderResponseMapper = orderResponseMapper;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }
    
    @PostMapping("/complete")
    public OrderResponseDto completeOrder(@RequestParam @Positive @Valid Long userId) {
        return orderResponseMapper.toDto(orderService
                .completeOrder(shoppingCartService.getByUser(userService.findById(userId))));
    }
    
    @GetMapping
    public List<OrderResponseDto> getOrdersHistory(@RequestParam @Positive @Valid Long userId) {
        return orderService.getOrdersHistory(userService.findById(userId)).stream()
                .map(orderResponseMapper::toDto).collect(Collectors.toList());
    }
}
