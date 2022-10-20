package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class OrderController {
    private final DtoResponseMapper<OrderResponseDto, Order> mapper;
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(@RequestParam Long userId) {
        Order order = orderService.completeOrder(shoppingCartService
                .getByUser(userService.get(userId)));
        return mapper.toDto(order);
    }

    @GetMapping
    public List<OrderResponseDto> getOrdersHistory(@RequestParam Long userId) {
        return orderService.getOrdersHistory(userService.get(userId))
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
