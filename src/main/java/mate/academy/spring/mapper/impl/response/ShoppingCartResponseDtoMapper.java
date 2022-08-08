package mate.academy.spring.mapper.impl.response;

import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.ShoppingCardResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartResponseDtoMapper implements
        DtoResponseMapper<ShoppingCardResponseDto, ShoppingCart> {
    @Override
    public ShoppingCardResponseDto toDto(ShoppingCart shoppingCart) {
        ShoppingCardResponseDto shoppingCardResponseDto = new ShoppingCardResponseDto();
        shoppingCardResponseDto.setId(shoppingCart.getId());
        shoppingCardResponseDto.setTicketsIds(shoppingCart.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        return shoppingCardResponseDto;
    }
}
