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
    private static final String DATE_PATTERN = "dd.MM.yyyy HH:mm";

    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setId(order.getId());
        dto.setOrderDate(order.getOrderDate()
                .format(DateTimeFormatter.ofPattern(DATE_PATTERN)));
        dto.setUserId(order.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        dto.setUser(order.getUser());
        return dto;
    }
}
