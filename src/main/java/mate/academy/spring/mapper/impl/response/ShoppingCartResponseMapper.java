package mate.academy.spring.mapper.impl.response;

import java.util.ArrayList;
import java.util.List;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartResponseMapper implements
        DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> {

    @Override
    public ShoppingCartResponseDto toDto(ShoppingCart cart) {
        List<Long> ticketsIds = new ArrayList<>();
        cart.getTickets().stream()
                .mapToLong(Ticket::getId)
                .forEach(ticketsIds::add);
        ShoppingCartResponseDto dto = new ShoppingCartResponseDto();
        dto.setTickets(ticketsIds);
        dto.setUserId(cart.getId());
        return dto;
    }
}
