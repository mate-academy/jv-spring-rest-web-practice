package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final ShoppingCartService shoppingCartService;
    private final OrderService orderService;
    private final DtoResponseMapper<OrderResponseDto, Order> dtoResponseMapper;

    @Autowired
    public OrderController(ShoppingCartService shoppingCartService,
                           OrderService orderService,
                           DtoResponseMapper<OrderResponseDto, Order> dtoResponseMapper) {
        this.shoppingCartService = shoppingCartService;
        this.orderService = orderService;
        this.dtoResponseMapper = dtoResponseMapper;
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(@RequestParam Long userId) {
        User user = new User();
        user.setId(userId);
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        return dtoResponseMapper.toDto(orderService.completeOrder(shoppingCart));
    }

    @GetMapping
    public List<OrderResponseDto> getOrderHistory(@RequestParam Long userId) {
        User user = new User();
        user.setId(userId);
        return orderService.getOrdersHistory(user).stream()
                .map(dtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
