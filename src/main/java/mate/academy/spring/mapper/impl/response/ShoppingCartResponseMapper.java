package mate.academy.spring.mapper.impl.response;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartResponseMapper implements
        DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> {
    @Override
    public ShoppingCartResponseDto toDto(ShoppingCart object) {
        ShoppingCartResponseDto dto = new ShoppingCartResponseDto();
        List<Long> ticketsId = object.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList());
        dto.setId(object.getId());
        dto.setTicketsId(ticketsId);
        return dto;
    }
}
