package mate.academy.spring.mapper.impl.response;

import java.util.stream.Collectors;
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
        orderResponseDto.setTicketsIds(
                order.getTickets()
                        .stream()
                        .map(ticket -> ticket.getId())
                        .collect(Collectors.toList()));
        orderResponseDto.setId(order.getId());
        return orderResponseDto;
    }
}
