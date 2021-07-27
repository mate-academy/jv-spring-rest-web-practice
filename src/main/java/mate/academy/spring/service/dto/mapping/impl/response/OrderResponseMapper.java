package mate.academy.spring.service.dto.mapping.impl.response;

import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper implements DtoResponseMapper<OrderResponseDto, Order> {
    private static final String DATETIME_PATTERN = "dd.MM.yyyy HH:mm";

    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setTicketsId(order.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        orderResponseDto.setOrderDate(order.getOrderDate()
                .format(DateTimeFormatter.ofPattern(DATETIME_PATTERN)));
        return orderResponseDto;
    }
}
