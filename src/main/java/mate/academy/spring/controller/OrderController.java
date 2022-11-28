package mate.academy.spring.controller;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.impl.request.ShoppingCartRequestMapper;
import mate.academy.spring.mapper.impl.response.OrderResponseMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.request.ShoppingCartRequestDto;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final ShoppingCartRequestMapper shoppingCartRequestMapper;
    private final UserService userService;
    private final OrderResponseMapper orderResponseMapper;
    private final OrderService orderService;

    public OrderController(ShoppingCartRequestMapper shoppingCartRequestMapper,
                           UserService userService,
                           OrderResponseMapper orderResponseMapper,
                           OrderService orderService) {
        this.shoppingCartRequestMapper = shoppingCartRequestMapper;
        this.userService = userService;
        this.orderResponseMapper = orderResponseMapper;
        this.orderService = orderService;
    }

    @PostMapping("/complete/{id}")
    public OrderResponseDto completeOrder(@PathVariable @Valid Long id,
                                          @RequestParam @Valid
                                          ShoppingCartRequestDto shoppingCartRequestDto) {
        ShoppingCart shoppingCart = shoppingCartRequestMapper.fromDto(shoppingCartRequestDto);
        shoppingCart.setId(id);
        shoppingCart.setUser(userService.get(id));
        return orderResponseMapper.toDto(orderService.completeOrder(shoppingCart));
    }

    @GetMapping("/{id}")
    public List<OrderResponseDto> getOrderHistory(@PathVariable @Valid Long id) {
        return orderService.getOrdersHistory(userService.get(id)).stream()
                .map(orderResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
