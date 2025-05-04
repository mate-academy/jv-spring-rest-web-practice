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
    public ShoppingCartResponseDto toDto(ShoppingCart object) {
        ShoppingCartResponseDto shoppingCartResponseDto = new ShoppingCartResponseDto();

        List<Long> ticketId = new ArrayList<>();
        for (Ticket ticket : object.getTickets()) {
            ticketId.add(ticket.getId());
        }
        shoppingCartResponseDto.setTicketsId(ticketId);
        shoppingCartResponseDto.setId(object.getId());
        shoppingCartResponseDto.setUserId(object.getUser().getId());
        return shoppingCartResponseDto;
    }
}
