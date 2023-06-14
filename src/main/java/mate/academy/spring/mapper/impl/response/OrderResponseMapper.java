package mate.academy.spring.mapper.impl.response;

import java.util.ArrayList;
import java.util.List;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper implements DtoResponseMapper<OrderResponseDto, Order> {
    @Override
    public OrderResponseDto toDto(Order object) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        List<Long> ticketsId = new ArrayList<>();
        if (object.getTickets() != null) {
            for (Ticket ticket : object.getTickets()) {
                ticketsId.add(ticket.getId());
            }
        }
        orderResponseDto.setId(object.getId());
        orderResponseDto.setTicketsId(ticketsId);
        orderResponseDto.setUserId(object.getUser().getId());
        orderResponseDto.setOrderDate(object.getOrderDate());
        return orderResponseDto;
    }
}
