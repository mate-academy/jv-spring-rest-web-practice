package mate.academy.spring.controller;

import java.util.ArrayList;
import java.util.List;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.impl.response.OrderResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final OrderResponseMapper responseMapper;

    public OrderController(OrderService orderService, ShoppingCartService shoppingCartService,
                           UserService userService, OrderResponseMapper responseMapper) {
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.responseMapper = responseMapper;
    }

    @PostMapping(name = "/complete/{id}")
    public void completeOrder(@PathVariable Long id) {
        orderService.completeOrder(shoppingCartService.getByUser(userService.get(id)));
    }

    @GetMapping(name = "{id}")
    public List<OrderResponseDto> getHistory(@PathVariable Long id) {
        List<OrderResponseDto> responseDtoList = new ArrayList<>();
        for (Order order : orderService.getOrdersHistory(userService.get(id))) {
            responseDtoList.add(responseMapper.toDto(order));
        }
        return responseDtoList;
    }
}
