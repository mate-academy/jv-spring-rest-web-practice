package mate.academy.spring.mapper.impl.response;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper implements DtoResponseMapper<OrderResponseDto, Order> {
    @Override
    public OrderResponseDto toDto(Order object) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(object.getId());
        responseDto.setUserId(object.getUser().getId());
        responseDto.setOrderDate(object.getOrderDate());
        responseDto.setUserId(object.getUser().getId());
        return responseDto;
    }
}
