package mate.academy.spring.mapper.impl.response;

import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper implements DtoResponseMapper<OrderResponseDto, Order> {

    private final TicketResponseMapper ticketResponseMapper;
    private final UserResponseMapper userResponseMapper;

    public OrderResponseMapper(TicketResponseMapper ticketResponseMapper,
                               UserResponseMapper userResponseMapper) {
        this.ticketResponseMapper = ticketResponseMapper;
        this.userResponseMapper = userResponseMapper;
    }

    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(order.getId());
        responseDto.setTickets(order.getTickets()
                .stream()
                .map(ticketResponseMapper::toDto)
                .collect(Collectors.toList()));
        responseDto.setUser(userResponseMapper.toDto(order.getUser()));
        return responseDto;
    }
}
