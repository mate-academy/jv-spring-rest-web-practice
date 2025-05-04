package mate.academy.spring.mapper.impl.response;

import java.util.ArrayList;
import java.util.List;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper implements DtoResponseMapper<OrderResponseDto, Order> {
    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setOrderDate(order.getOrderDate());
        orderResponseDto.setId(order.getId());
        orderResponseDto.setUserId(order.getUser().getId());
        List<Long> tickets = new ArrayList<>();
        order.getTickets().forEach(t -> tickets.add(t.getId()));
        orderResponseDto.setTickets(tickets);
        return orderResponseDto;
    }
}
