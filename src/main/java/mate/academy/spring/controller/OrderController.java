package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.impl.response.OrderResponseDtoMapper;
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
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final OrderResponseDtoMapper responseDtoMapper;

    public OrderController(OrderService orderService,
                           ShoppingCartService shoppingCartService,
                           UserService userService,
                           OrderResponseDtoMapper responseDtoMapper) {
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.responseDtoMapper = responseDtoMapper;
    }

    @PostMapping("/complete")
    public OrderResponseDto complete(@RequestParam Long id) {
        return responseDtoMapper.toDto(orderService
                .completeOrder(shoppingCartService
                        .getByUser(userService.get(id))));
    }

    @GetMapping
    public List<OrderResponseDto> getAllByUser(@RequestParam Long id) {
        return orderService.getOrdersHistory(userService.get(id)).stream()
                .map(responseDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
