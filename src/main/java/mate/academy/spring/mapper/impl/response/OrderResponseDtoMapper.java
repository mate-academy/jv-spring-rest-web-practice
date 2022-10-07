package mate.academy.spring.mapper.impl.response;

import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseDtoMapper implements DtoResponseMapper<OrderResponseDto, Order> {
    @Override
    public OrderResponseDto toDto(Order object) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setOrderDate(object.getOrderDate());
        orderResponseDto.setId(object.getId());
        orderResponseDto.setUserId(object.getUser().getId());
        orderResponseDto.setTicketIds(object.getTickets().stream()
                .map(o -> o.getId())
                .collect(Collectors.toList()));
        return orderResponseDto;
    }
}
