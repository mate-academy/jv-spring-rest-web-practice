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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final ShoppingCartService shoppingCartService;
    private final DtoResponseMapper<OrderResponseDto, Order> dtoResponseMapper;
    private final OrderService orderService;

    public OrderController(ShoppingCartService shoppingCartService,
                           DtoResponseMapper<OrderResponseDto, Order> dtoResponseMapper,
                           OrderService orderService) {
        this.shoppingCartService = shoppingCartService;
        this.dtoResponseMapper = dtoResponseMapper;
        this.orderService = orderService;
    }

    @PostMapping("/complete")
    public OrderResponseDto complete(@RequestParam Long userId) {
        User user = new User();
        user.setId(userId);
        ShoppingCart scByUser = shoppingCartService.getByUser(user);
        Order orderFromDB = orderService.completeOrder(scByUser);
        return dtoResponseMapper.toDto(orderFromDB);
    }

    @GetMapping
    public List<OrderResponseDto> getAll(@RequestParam Long userId) {
        User user = new User();
        user.setId(userId);
        return orderService.getOrdersHistory(user).stream()
                .map(dtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
