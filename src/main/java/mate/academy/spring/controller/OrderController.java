package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.ShoppingCartRequestDto;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;
    private final DtoResponseMapper<OrderResponseDto, Order> orderDtoResponseMapper;
    private final DtoRequestMapper<ShoppingCartRequestDto, ShoppingCart>
            shoppingCartDtoRequestMapper;

    public OrderController(OrderService orderService,
                           ShoppingCartService shoppingCartService,
                           DtoResponseMapper<OrderResponseDto, Order> orderDtoResponseMapper,
                           DtoRequestMapper<ShoppingCartRequestDto, ShoppingCart>
                                   shoppingCartDtoRequestMapper) {
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.orderDtoResponseMapper = orderDtoResponseMapper;
        this.shoppingCartDtoRequestMapper = shoppingCartDtoRequestMapper;
    }

    @GetMapping
    public List<OrderResponseDto> getHistoryForUser(@RequestParam Long userId) {
        User user = new User();
        user.setId(userId);
        return orderService.getOrdersHistory(user)
                .stream()
                .map(orderDtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/complete")
    public OrderResponseDto add(@RequestParam Long userId) {
        User user = new User();
        user.setId(userId);
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        return orderDtoResponseMapper.toDto(orderService.completeOrder(shoppingCart));
    }
}
