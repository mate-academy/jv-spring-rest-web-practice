package mate.academy.spring.mapper.impl.response;

import java.util.List;
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
        orderResponseDto.setId(order.getId());
        orderResponseDto.setUser(order.getUser());
        List<Long> ticketIds = order.getTickets().stream()
                        .map(ticket -> ticket.getId())
                        .collect(Collectors.toList());
        orderResponseDto.setTicketIds(ticketIds);
        orderResponseDto.setOrderDate(order.getOrderDate());
        return orderResponseDto;
    }
}
