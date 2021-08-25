package mate.academy.spring.service.dto.mapping.impl.response;

import java.util.ArrayList;
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
        responseDto.setUserId(order.getUser().getId());
        responseDto.setTicketIds(new ArrayList<>());
        for (Ticket ticket : order.getTickets()) {
            responseDto.getTicketIds().add(ticket.getId());
        }
        return responseDto;
    }
}
