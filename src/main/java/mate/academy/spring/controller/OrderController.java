package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private DtoResponseMapper<OrderResponseDto, Order> dtoResponse;
    private OrderService orderService;
    private ShoppingCartService shoppingCartService;
    private UserService userService;


    @PostMapping("/complete")
    OrderResponseDto complete(@RequestParam Long id) {
        return dtoResponse.toDto(orderService.completeOrder(shoppingCartService.getByUser(userService.get(id))));
    }

    @GetMapping
    List<OrderResponseDto> getOrderHistory(@RequestParam Long id) {
        return orderService
                .getOrdersHistory(userService.get(id))
                .stream()
                .map(o -> dtoResponse.toDto(o))
                .collect(Collectors.toList());
    }

}
