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
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(order.getId());
        responseDto.setOrderDate(order.getOrderDate());
        List<Long> tickets = new ArrayList<>();
        for (Ticket ticket : order.getTickets()) {
            tickets.add(ticket.getId());
        }
        responseDto.setTicketsId(tickets);
        responseDto.setUserId(order.getUser().getId());
        return responseDto;
    }
}
