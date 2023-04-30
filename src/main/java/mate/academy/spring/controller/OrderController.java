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
    private final DtoResponseMapper<OrderResponseDto, Order> responseMapper;
    private final OrderService orderService;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    public OrderController(DtoResponseMapper<OrderResponseDto,
            Order> responseMapper, OrderService orderService,
                           UserService userService,
                           ShoppingCartService shoppingCartService) {
        this.responseMapper = responseMapper;
        this.orderService = orderService;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("complete")
    public OrderResponseDto complete(@RequestParam Long id) {
        return responseMapper.toDto(orderService.completeOrder(
                shoppingCartService.getByUser(userService.get(id))
        ));
    }

    @GetMapping
    public List<OrderResponseDto> getOrderHistory(@RequestParam Long id) {
        return orderService.getOrdersHistory(userService.get(id))
                .stream()
                .map(responseMapper::toDto)
                .collect(Collectors.toList());
    }
}
