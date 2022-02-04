package mate.academy.spring.controller;

import java.util.List;
import java.util.NoSuchElementException;
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
    private final UserService userService;
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;
    private final DtoResponseMapper<OrderResponseDto, Order> orderResponseDtoMapper;

    public OrderController(UserService userService, OrderService orderService,
                           ShoppingCartService shoppingCartService,
                           DtoResponseMapper<OrderResponseDto, Order> orderResponseDtoMapper) {
        this.userService = userService;
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.orderResponseDtoMapper = orderResponseDtoMapper;
    }

    @GetMapping("/")
    public List<OrderResponseDto> getUOrdersHistoryByUser(@RequestParam Long userId) {
        try {
            return orderService.getOrdersHistory(userService.get(userId)).stream()
                    .map(orderResponseDtoMapper::toDto)
                    .collect(Collectors.toList());
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Cant find orders history by user id " + userId);
        }
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(@RequestParam Long userId) {
        Order order = orderService.completeOrder(shoppingCartService
                  .getByUser(userService.get(userId)));
        return orderResponseDtoMapper.toDto(order);
    }
}
