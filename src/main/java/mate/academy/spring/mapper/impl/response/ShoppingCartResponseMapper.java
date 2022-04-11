package mate.academy.spring.mapper.impl.response;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartResponseMapper
        implements DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> {
    @Override
    public ShoppingCartResponseDto toDto(ShoppingCart object) {
        ShoppingCartResponseDto response = new ShoppingCartResponseDto();
        response.setId(object.getId());
        object.getTickets()
                .stream()
                .map(Ticket::getId)
                .forEach(response.getTicketIds()::add);
        response.setUserId(object.getUser().getId());
        return response;
    }
}
