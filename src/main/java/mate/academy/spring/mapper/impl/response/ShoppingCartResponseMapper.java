package mate.academy.spring.mapper.impl.response;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class ShoppingCartResponseMapper implements DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> {
    @Override
    public ShoppingCartResponseDto toDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto shoppingCartResponseDto = new ShoppingCartResponseDto();
        shoppingCartResponseDto.setTicketsId(shoppingCart.getTickets().stream().map(t -> t.getId()).collect(Collectors.toList()));
        shoppingCartResponseDto.setId(shoppingCart.getId());
        return shoppingCartResponseDto;
    }
}
