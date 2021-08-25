package mate.academy.spring.service.dto.mapping.impl.response;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartResponseDtoMapper implements
        DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> {

    @Override
    public ShoppingCartResponseDto toDto(ShoppingCart object) {
        ShoppingCartResponseDto dto = new ShoppingCartResponseDto();
        dto.setId(object.getId());
        List<Long> tickets = object.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList());
        dto.setTicketIds(tickets);
        return dto;
    }
}
