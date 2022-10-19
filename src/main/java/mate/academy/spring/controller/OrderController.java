package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.OrderResponseMapper;
import mate.academy.spring.model.dto.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;
    private UserService userService;
    private OrderResponseMapper orderResponseMapper;
    private ShoppingCartService shoppingCartService;

    public OrderController(OrderService orderService, UserService userService,
                           OrderResponseMapper orderResponseMapper,
                           ShoppingCartService shoppingCartService) {
        this.orderService = orderService;
        this.userService = userService;
        this.orderResponseMapper = orderResponseMapper;
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping
    public List<OrderResponseDto> getOrdersHistory(@RequestParam Long userId) {
        return orderService.getOrdersHistory(userService.get(userId)).stream()
                .map(orderResponseMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/complete")
    public OrderResponseDto complete(@RequestParam Long userId){
        return orderResponseMapper.toDto(
                orderService.completeOrder(
                        shoppingCartService.getByUser(
                                userService.get(userId))));
    }
}
