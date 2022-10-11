package mate.academy.spring.mapper.impl.response;

import java.util.stream.Collectors;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper {
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto orderResponseDto =
                new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setOrderDate(order.getOrderDate());
        orderResponseDto.setTicketsId(order.getTickets().stream()
                .map(Ticket::getId).collect(Collectors.toList()));
        orderResponseDto.setUserId(order.getUser().getId());
        return orderResponseDto;
    }
}
