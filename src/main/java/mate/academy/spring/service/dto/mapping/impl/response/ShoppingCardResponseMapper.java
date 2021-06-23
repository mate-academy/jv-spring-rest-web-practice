package mate.academy.spring.service.dto.mapping.impl.response;

import java.util.stream.Collectors;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.ShoppingCardResponseDto;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCardResponseMapper implements
        DtoResponseMapper<ShoppingCardResponseDto, ShoppingCart> {
    @Override
    public ShoppingCardResponseDto toDto(ShoppingCart shoppingCart) {
        ShoppingCardResponseDto responseDto = new ShoppingCardResponseDto();
        responseDto.setId(shoppingCart.getId());
        responseDto.setTicketIds(shoppingCart.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        responseDto.setUserId(shoppingCart.getUser().getId());
        return responseDto;
    }
}
