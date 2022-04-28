package mate.academy.spring.mapper.impl.request;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.request.ShoppingCartRequestDto;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartRequestMapper implements
        DtoRequestMapper<ShoppingCart, ShoppingCartRequestDto> {
    @Override
    public ShoppingCartRequestDto fromDto(ShoppingCart shoppingCart) {
        return null;
    }
}
