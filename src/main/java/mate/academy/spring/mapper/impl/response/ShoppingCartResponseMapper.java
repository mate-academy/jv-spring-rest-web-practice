package mate.academy.spring.mapper.impl.response;

import java.util.ArrayList;
import java.util.List;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartResponseMapper implements DtoResponseMapper<ShoppingCartResponseDto,
                                                                                ShoppingCart> {
    @Override
    public ShoppingCartResponseDto toDto(ShoppingCart object) {
        ShoppingCartResponseDto shoppingCartResponseDto = new ShoppingCartResponseDto();
        List<Long> ticketsId = new ArrayList<>();
        for (Ticket ticket : object.getTickets()) {
            ticketsId.add(ticket.getId());
        }
        shoppingCartResponseDto.setTicketsId(ticketsId);
        shoppingCartResponseDto.setId(object.getId());
        return shoppingCartResponseDto;
    }
}
