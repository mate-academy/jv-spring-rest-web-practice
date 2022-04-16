package mate.academy.spring.service.dto.mapping.impl.response;

import java.util.stream.Collectors;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCardResponseMapper implements DtoResponseMapper<ShoppingCartResponseDto,
        ShoppingCart> {
    @Override
    public ShoppingCartResponseDto toDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto shoppingCardResponseDto = new ShoppingCartResponseDto();
        shoppingCardResponseDto.setId(shoppingCart.getId());
        shoppingCardResponseDto.setTicketsId(shoppingCart.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        shoppingCardResponseDto.setUserEmail(shoppingCart.getUser().getEmail());
        return shoppingCardResponseDto;
    }
}
