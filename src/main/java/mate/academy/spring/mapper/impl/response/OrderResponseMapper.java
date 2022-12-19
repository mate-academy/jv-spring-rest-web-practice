package mate.academy.spring.mapper.impl.response;

import mate.academy.spring.model.Order;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderResponseMapper {
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(order.getId());
        responseDto.setOrderDate(order.getOrderDate());
        responseDto.setUserId(order.getUser().getId());
        List<Long> ticketIds = order.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList());
        responseDto.setTicketIds(ticketIds);
        return responseDto;
    }
}
