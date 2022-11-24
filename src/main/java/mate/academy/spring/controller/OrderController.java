package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.impl.response.OrderResponseMapper;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final OrderService orderService;
    private final OrderResponseMapper orderResponseDtoMapper;

    @Autowired
    public OrderController(UserService userService,
                           ShoppingCartService shoppingCartService,
                           OrderService orderService,
                           OrderResponseMapper orderResponseDtoMapper) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.orderService = orderService;
        this.orderResponseDtoMapper = orderResponseDtoMapper;
    }

    @PostMapping("/orders/complete")
    public OrderResponseDto completeUserOrder(@RequestParam Long userId) {
        return orderResponseDtoMapper.toDto(
                orderService.completeOrder(
                        shoppingCartService.getByUser(userService.get(userId))
                )
        );
    }

    @GetMapping("/orders")
    public List<OrderResponseDto> getOrdersByUserId(@RequestParam Long userId) {
        return orderService.getOrdersHistory(userService.get(userId))
                .stream().map(orderResponseDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
