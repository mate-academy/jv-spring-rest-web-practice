package mate.academy.spring.mapper.impl.response;

import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.response.ShoppingCartDto;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapper implements DtoResponseMapper<ShoppingCartDto, ShoppingCart> {
    @Override
    public ShoppingCartDto toDto(ShoppingCart shoppingCart) {
        ShoppingCartDto shoppingCartDto = new ShoppingCartDto();
        shoppingCartDto.setId(shoppingCart.getId());
        shoppingCartDto.setUserId(shoppingCart.getId());
        shoppingCartDto.setTicketsId(shoppingCart.getTickets().stream()
                .map(t -> t.getId())
                .collect(Collectors.toList()));
        return shoppingCartDto;
    }
}
