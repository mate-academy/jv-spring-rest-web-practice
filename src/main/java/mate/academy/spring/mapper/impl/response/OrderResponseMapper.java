package mate.academy.spring.mapper.impl.response;

import java.util.ArrayList;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper implements DtoResponseMapper<OrderResponseDto, Order> {
    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setTickets(new ArrayList<>(order.getTickets()));
        orderResponseDto.setOrderDate(order.getOrderDate());
        orderResponseDto.setUser(order.getUser());
        return orderResponseDto;
    }
}
