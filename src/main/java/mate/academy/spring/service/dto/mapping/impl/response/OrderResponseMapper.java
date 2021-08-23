package mate.academy.spring.service.dto.mapping.impl.response;

import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper implements DtoResponseMapper<OrderResponseDto, Order> {
    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setTickets(order.getTickets());
        orderResponseDto.setOrderDate(order.getOrderDate());
        orderResponseDto.setUser(order.getUser());
        return orderResponseDto;
    }
}
