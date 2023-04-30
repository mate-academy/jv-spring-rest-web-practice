package mate.academy.spring.mapper.impl.response;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.response.ShopingCartResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartResponseMapper
        implements DtoResponseMapper<ShopingCartResponseDto, ShoppingCart> {
    @Override
    public ShopingCartResponseDto toDto(ShoppingCart shoppingCart) {
        ShopingCartResponseDto shopingCartResponseDto = new ShopingCartResponseDto();
        shopingCartResponseDto.setId(shoppingCart.getId());
        shopingCartResponseDto.setTicketIds(shoppingCart.getTickets()
                .stream()
                .map(e -> e.getId())
                .toList());
        return shopingCartResponseDto;
    }
}
