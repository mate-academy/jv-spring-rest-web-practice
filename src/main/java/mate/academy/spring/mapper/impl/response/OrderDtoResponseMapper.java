package mate.academy.spring.mapper.impl.response;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OrderDtoResponseMapper implements DtoResponseMapper<OrderResponseDto, Order> {
    @Override
    public OrderResponseDto toDto(Order obj) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(obj.getId());
        List<Long> ticketsId = obj.getTickets()
                .stream().map(Ticket::getId).collect(Collectors.toList());
        responseDto.setTickets(ticketsId);
        responseDto.setUser(obj.getUser().getId());
        responseDto.setOrderDate(obj.getOrderDate());
        return responseDto;
    }
}
