package mate.academy.spring.mapper.impl.response;

import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShoppingCartResponseMapper {
    public ShoppingCartResponseDto toDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto responseDto = new ShoppingCartResponseDto();
        responseDto.setId(shoppingCart.getId());
        responseDto.setUserId(shoppingCart.getUser().getId());
        List<Long> ticketIds = shoppingCart.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList());
        responseDto.setTicketIds(ticketIds);
        return responseDto;
    }
}
