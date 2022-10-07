package mate.academy.spring.mapper.impl.response;

import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartResponseDtoMapper implements
        DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> {
    @Override
    public ShoppingCartResponseDto toDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto cartResponseDto = new ShoppingCartResponseDto();
        cartResponseDto.setUserId(shoppingCart.getId());
        cartResponseDto.setTicketIds(shoppingCart.getTickets().stream()
                .map(c -> c.getId())
                .collect(Collectors.toList()));
        return cartResponseDto;
    }
}
