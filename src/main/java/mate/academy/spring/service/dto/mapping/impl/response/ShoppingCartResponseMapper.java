package mate.academy.spring.service.dto.mapping.impl.response;

import java.util.ArrayList;
import java.util.List;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartResponseMapper implements
        DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> {
    @Override
    public ShoppingCartResponseDto toDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto responseDto = new ShoppingCartResponseDto();
        responseDto.setId(shoppingCart.getId());
        List<Long> ticketsIds = new ArrayList<>();
        for (Ticket ticket : shoppingCart.getTickets()) {
            ticketsIds.add(ticket.getId());
        }
        responseDto.setTicketsId(ticketsIds);
        return responseDto;
    }
}
