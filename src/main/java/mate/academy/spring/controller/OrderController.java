package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.mapper.impl.request.ShoppingCartRequestMapper;
import mate.academy.spring.mapper.impl.response.OrderResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.request.ShoppingCartRequestDto;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final DtoResponseMapper<OrderResponseDto, Order> orderResponseMapper;
    private final DtoRequestMapper<ShoppingCartRequestDto, ShoppingCart> shoppingCartRequestMapper;
    private final UserService userService;

    public OrderController(OrderService orderService,
                           OrderResponseMapper orderResponseMapper,
                           ShoppingCartRequestMapper shoppingCartRequestMapper,
                           UserService userService) {
        this.orderService = orderService;
        this.orderResponseMapper = orderResponseMapper;
        this.shoppingCartRequestMapper = shoppingCartRequestMapper;
        this.userService = userService;
    }

    @PostMapping("/{id}")
    OrderResponseDto completeOrder(@PathVariable Long id,
                                   @RequestBody ShoppingCartRequestDto shoppingCartRequestDto) {
        ShoppingCart shoppingCart = shoppingCartRequestMapper.fromDto(shoppingCartRequestDto);
        shoppingCart.setId(id);
        shoppingCart.setUser(userService.get(id));
        Order order = orderService.completeOrder(shoppingCart);
        return orderResponseMapper.toDto(order);
    }

    @GetMapping("/{id}")
    List<OrderResponseDto> getOrdersHistory(@PathVariable Long id) {
        return orderService.getOrdersHistory(userService.get(id)).stream()
                .map(orderResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
