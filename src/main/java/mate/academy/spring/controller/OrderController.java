package mate.academy.spring.controller;

import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final DtoResponseMapper<OrderResponseDto, Order>
            orderDtoResponseMapper;


    public OrderController(OrderService orderService,
                           DtoResponseMapper<OrderResponseDto, Order>
                                   orderDtoResponseMapper) {
        this.orderService = orderService;
        this.orderDtoResponseMapper = orderDtoResponseMapper;
    }
}
