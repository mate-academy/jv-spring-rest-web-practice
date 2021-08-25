package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final DtoResponseMapper<OrderResponseDto, Order> dtoResponseMapper;

    public OrderController(OrderService orderService,
                           ShoppingCartService shoppingCartService, UserService userService,
                           DtoResponseMapper<OrderResponseDto, Order> dtoResponseMapper) {
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.dtoResponseMapper = dtoResponseMapper;
    }

    @GetMapping
    public List<OrderResponseDto> getOrderByUserId(@RequestParam Long id) {
        return orderService.getOrdersHistory(userService.getById(id)).stream()
                .map(dtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/complete")
    public OrderResponseDto createOrder(@RequestParam Long id) {
        return dtoResponseMapper.toDto(orderService.completeOrder(shoppingCartService
                .getByUser(userService.getById(id))));
    }
}
