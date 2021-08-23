package mate.academy.spring.service.dto.mapping.impl.response;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper implements DtoResponseMapper<OrderResponseDto, Order> {
    @Override
    public OrderResponseDto toDto(Order object) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setId(object.getId());
        dto.setOrderDate(object.getOrderDate()
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")));
        List<Long> ticketsId = object.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList());
        dto.setTickets(ticketsId);
        dto.setUserId(object.getUser().getId());
        return dto;
    }
}
