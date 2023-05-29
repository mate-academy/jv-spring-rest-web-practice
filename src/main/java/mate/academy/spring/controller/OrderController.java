package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
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
    private final OrderService orderService;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final DtoRequestMapper<OrderRequestDto, Order> orderDtoRequestMapper;
    private final DtoResponseMapper<OrderResponseDto, Order> orderDtoResponseMapper;

    public OrderController(OrderService orderService,
                           UserService userService,
                           ShoppingCartService shoppingCartService,
                           DtoRequestMapper<OrderRequestDto, Order> dtoRequestMapper,
                           DtoResponseMapper<OrderResponseDto, Order> dtoResponseMapper) {
        this.orderService = orderService;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.orderDtoRequestMapper = dtoRequestMapper;
        this.orderDtoResponseMapper = dtoResponseMapper;
    }

    @PostMapping("/complete")
    public OrderResponseDto complete(@RequestParam Long userId,
                                       @RequestBody OrderRequestDto dto) {
        User user = userService.get(userId);
        Order order = orderDtoRequestMapper.fromDto(dto);
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        shoppingCart.setTickets(order.getTickets());
        Order orderUpdate = orderService.completeOrder(shoppingCart);
        return orderDtoResponseMapper.toDto(orderUpdate);
    }

    @GetMapping
    public List<OrderResponseDto> get(@RequestParam Long userId) {
        return orderService.getOrdersHistory(userService.get(userId)).stream()
                .map(orderDtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }

}
