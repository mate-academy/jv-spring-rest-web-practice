package mate.academy.spring.service.dto.mapping.impl.response;

import java.util.ArrayList;
import java.util.List;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper implements DtoResponseMapper<OrderResponseDto, Order> {
    @Override
    public OrderResponseDto toDto(Order object) {
        List<Long> ticketsId = new ArrayList<>();
        for (Ticket ticket : object.getTickets()) {
            ticketsId.add(ticket.getId());
        }
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(object.getId());
        orderResponseDto.setOrderDate(object.getOrderDate());
        orderResponseDto.setUserId(object.getUser().getId());
        orderResponseDto.setTicketsId(ticketsId);
        return orderResponseDto;
    }
}
