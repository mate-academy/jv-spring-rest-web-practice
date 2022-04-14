package mate.academy.spring.mapper.impl.response;

import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.ShoppingCartReponseDto;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartResponseMapper
        implements DtoResponseMapper<ShoppingCartReponseDto, ShoppingCart> {
    @Override
    public ShoppingCartReponseDto toDto(ShoppingCart cart) {
        ShoppingCartReponseDto dto = new ShoppingCartReponseDto();
        dto.setCartId(cart.getId());
        dto.setTicketIds(cart.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        return dto;
    }
}
