package mate.academy.spring.mapper.impl.request;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.request.ShoppingCartRequestDto;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartRequestMapper
        implements DtoRequestMapper<ShoppingCartRequestDto, ShoppingCart> {
    @Override
    public ShoppingCart fromDto(ShoppingCartRequestDto dto) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(dto.getUser());
        shoppingCart.setTickets(dto.getTickets());
        return shoppingCart;
    }
}
