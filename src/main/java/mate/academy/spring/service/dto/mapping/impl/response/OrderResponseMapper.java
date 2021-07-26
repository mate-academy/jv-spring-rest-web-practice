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
public class OrderResponseMapper
        implements DtoResponseMapper<OrderResponseDto, Order> {

    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setUserId(order.getUser().getId());
        orderResponseDto.setId(order.getId());
        orderResponseDto.setOrderDate(order.getOrderDate()
                .format(DateTimeFormatter
                .ofPattern("dd.MM.yyyy HH:mm")));
        List<Long> ticketIds = order.getTickets()
                .stream()
                .mapToLong(Ticket::getId)
                .boxed()
                .collect(Collectors.toList());
        orderResponseDto.setTicketIds(ticketIds);
        return orderResponseDto;
    }
}
