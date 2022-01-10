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
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setOrderDate(order.getOrderDate());
        List<Long> ticketsIds = new ArrayList<>();
        for (Ticket ticket : order.getTickets()) {
            ticketsIds.add(ticket.getId());
        }
        orderResponseDto.setTicketsId(ticketsIds);
        orderResponseDto.setUserId(order.getUser().getId());
        return orderResponseDto;
    }
}
