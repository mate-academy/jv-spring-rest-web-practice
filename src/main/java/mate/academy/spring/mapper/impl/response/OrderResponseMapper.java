package mate.academy.spring.mapper.impl.response;

import java.util.ArrayList;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper implements DtoResponseMapper<OrderResponseDto, Order> {
    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setId(order.getId());
        ArrayList<Long> ticketIds = new ArrayList<>();
        order.getTickets().forEach(ticket -> ticketIds.add(ticket.getId()));
        dto.setTickets(ticketIds);
        dto.setOrderDate(order.getOrderDate());
        dto.setUser(order.getUser().getId());
        return dto;
    }
}
