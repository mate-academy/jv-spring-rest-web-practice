package mate.academy.spring.service.dto.mapping.impl.response;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartResponseMapper
        implements DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> {
    @Override
    public ShoppingCartResponseDto toDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto responseDto = new ShoppingCartResponseDto();
        responseDto.setId(shoppingCart.getId());
        responseDto.setUserId(shoppingCart.getUser().getId());
        List<Long> ticketsId = shoppingCart.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList());
        responseDto.setTicketsIds(ticketsId);
        return responseDto;
    }
}
