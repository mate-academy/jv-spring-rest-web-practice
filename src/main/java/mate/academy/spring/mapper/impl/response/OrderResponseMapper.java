package mate.academy.spring.mapper.impl.response;

import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper implements DtoResponseMapper<OrderResponseDto, Order> {
    public static final String DATE_TIME_PATTERN = "dd.MM.yyyy HH:mm";
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);

    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(order.getId());
        responseDto.setUserId(order.getUser().getId());
        responseDto.setOrderTime(order.getOrderDate().format(formatter));
        responseDto.setTicketIds(order.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        return responseDto;
    }
}
