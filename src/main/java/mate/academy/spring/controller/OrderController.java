package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;
    private DtoResponseMapper<OrderResponseDto, Order> dtoResponseMapper;
    private ShoppingCartService shoppingCartService;
    private UserService userService;

    public OrderController(OrderService orderService,
                           DtoResponseMapper<OrderResponseDto,
                                   Order> dtoResponseMapper,
                           ShoppingCartService shoppingCartService,
                           UserService userService) {
        this.orderService = orderService;
        this.dtoResponseMapper = dtoResponseMapper;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }

    @PostMapping("/complete")
    public OrderResponseDto complete(@RequestParam Long userId) {
        return dtoResponseMapper.toDto(
                orderService.completeOrder(
                        shoppingCartService.getByUser(userService.get(userId))));
    }

    @GetMapping("/{userId}")
    public List<OrderResponseDto> getOrdersHistory(@RequestParam Long userId) {
        return orderService.getOrdersHistory(userService.get(userId)).stream()
                .map(h -> dtoResponseMapper.toDto(h))
                .collect(Collectors.toList());
    }
}
