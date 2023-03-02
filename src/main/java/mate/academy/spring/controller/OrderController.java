package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.mapper.impl.request.ShoppingCartRequestMapper;
import mate.academy.spring.mapper.impl.response.OrderResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.ShoppingCartRequestDto;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private DtoResponseMapper<OrderResponseDto, Order> orderResponseMapper;
    private OrderService orderService;
    private DtoRequestMapper<ShoppingCartRequestDto, ShoppingCart> shoppingCartRequestMapper;
    private UserService userService;

    public OrderController(OrderResponseMapper orderResponseMapper,
                           OrderService orderService,
                           ShoppingCartRequestMapper shoppingCartRequestMapper,
                           UserService userService) {
        this.orderResponseMapper = orderResponseMapper;
        this.orderService = orderService;
        this.shoppingCartRequestMapper = shoppingCartRequestMapper;
        this.userService = userService;
    }

    @PostMapping("/complete")
    public OrderResponseDto complete(@RequestParam Long userId,
                                          @RequestBody ShoppingCartRequestDto
                                                  shoppingCartRequestDto) {
        Order completeOrder = orderService.completeOrder(shoppingCartRequestMapper
                .fromDto(shoppingCartRequestDto));
        return orderResponseMapper.toDto(completeOrder);
    }

    @GetMapping
    public List<OrderResponseDto> getHistory(@RequestParam Long userId) {
        User user = userService.get(userId);
        List<Order> ordersHistory = orderService.getOrdersHistory(user);
        return ordersHistory.stream()
                .map(orderResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
