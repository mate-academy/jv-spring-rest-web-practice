package mate.academy.spring.mapper.impl.response;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartResponseDtoMapper
        implements DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> {
    @Override
    public ShoppingCartResponseDto toDto(ShoppingCart model) {
        ShoppingCartResponseDto dto = new ShoppingCartResponseDto();
        dto.setId(model.getId());
        List<Long> tickets = model.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList());
        dto.setTicketIds(tickets);
        return dto;
    }
}
