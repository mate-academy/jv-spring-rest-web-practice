package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.request.OrderRequestDto;
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
    private DtoRequestMapper<OrderRequestDto, Order> orderRequestDto;
    private DtoResponseMapper<OrderResponseDto, Order> orderResponseDto;
    private ShoppingCartService shoppingCartService;
    private UserService userService;
    private OrderService orderService;

    @Autowired
    public OrderController(DtoRequestMapper<OrderRequestDto, Order> orderRequestDto,
                           DtoResponseMapper<OrderResponseDto, Order> orderResponseDto,
                           ShoppingCartService shoppingCartService, UserService userService,
                           OrderService orderService) {
        this.orderRequestDto = orderRequestDto;
        this.orderResponseDto = orderResponseDto;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.orderService = orderService;
    }

    @PostMapping("/orders/complete")
    public OrderResponseDto complete(@RequestParam Long userId) {
        Order order = orderService.completeOrder(shoppingCartService
                .getByUser(userService.get(userId)));
        return orderResponseDto.toDto(order);
    }

    @GetMapping("/orders")
    public List<OrderResponseDto> getHistory(@RequestParam Long userId) {
        List<Order> ordersHistory = orderService.getOrdersHistory(userService.get(userId));
        List<OrderResponseDto> orderResponseDtos = ordersHistory.stream()
                .map(order -> orderResponseDto.toDto(order))
                .collect(Collectors.toList());
        return orderResponseDtos;
    }
}
