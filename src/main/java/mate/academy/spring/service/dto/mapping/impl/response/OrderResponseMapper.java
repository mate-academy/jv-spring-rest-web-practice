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
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(order.getId());
        responseDto.setOrderDate(order.getOrderDate()
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")));
        List<Long> ticketIds = order.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList());
        responseDto.setTicketIds(ticketIds);
        responseDto.setUserId(order.getUser().getId());
        return responseDto;
    }
}
