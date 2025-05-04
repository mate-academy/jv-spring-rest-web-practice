package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
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
    private final ShoppingCartService shoppingCartService;
    private final DtoResponseMapper<OrderResponseDto, Order> orderDtoResponseMapper;

    public OrderController(OrderService orderService, ShoppingCartService shoppingCartService,
            DtoResponseMapper<OrderResponseDto, Order> orderDtoResponseMapper) {
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.orderDtoResponseMapper = orderDtoResponseMapper;
    }

    @GetMapping("/{id}")
    public List<OrderResponseDto> get(@PathVariable Long id) {
        User user = new User();
        user.setId(id);
        return orderService.getOrdersHistory(user).stream()
                .map(orderDtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public OrderResponseDto complete(@RequestBody OrderRequestDto dto) {
        User user = new User();
        user.setId(dto.getUserId());
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        return orderDtoResponseMapper.toDto(orderService.completeOrder(shoppingCart));
    }
}
