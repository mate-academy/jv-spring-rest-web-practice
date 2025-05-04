package mate.academy.spring.mapper.impl;

import java.util.ArrayList;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartResponseMapper implements
        DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> {

    @Override
    public ShoppingCartResponseDto toDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto dto = new ShoppingCartResponseDto();
        dto.setId(shoppingCart.getId());
        ArrayList<Long> ticketIds = new ArrayList<>();
        shoppingCart.getTickets().forEach(ticket -> ticketIds.add(ticket.getId()));
        dto.setTickets(ticketIds);
        dto.setUser(shoppingCart.getUser().getId());
        return dto;
    }
}
