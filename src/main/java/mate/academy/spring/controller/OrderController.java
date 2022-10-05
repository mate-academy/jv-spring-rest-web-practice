package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.OrderResponseMapper;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.OrderResponseDto;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;
    private final OrderResponseMapper responseMapper;
    private final ShoppingCartService shoppingCartService;


    public OrderController(OrderService orderService, UserService userService,
                           OrderResponseMapper responseMapper, ShoppingCartService shoppingCartService) {
        this.orderService = orderService;
        this.userService = userService;
        this.responseMapper = responseMapper;
        this.shoppingCartService = shoppingCartService;
    }


    @PostMapping("/complete")
    public OrderResponseDto completeOrder(@RequestParam Long id) {
        ShoppingCart shoppingCart
                = shoppingCartService.getByUser(userService.get(id));
        return responseMapper.toDto(orderService.completeOrder(shoppingCart));
    }

    @GetMapping("/{id}")
    public List<OrderResponseDto> getOrdersHistory(@PathVariable Long id) {
        User user = userService.get(id);
        return orderService.getOrdersHistory(user).stream()
                .map(responseMapper::toDto)
                .collect(Collectors.toList());
    }
}
