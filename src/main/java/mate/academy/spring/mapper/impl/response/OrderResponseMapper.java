package mate.academy.spring.mapper.impl.response;

import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper implements DtoResponseMapper<OrderResponseDto, Order> {
    @Override
    public OrderResponseDto toDto(Order object) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setId(object.getId());
        dto.setUser(object.getUser());
        dto.setOrderDate(object.getOrderDate());
        TicketResponseMapper mapper = new TicketResponseMapper();
        dto.setTickets(object.getTickets().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList()));
        return dto;
    }
}
