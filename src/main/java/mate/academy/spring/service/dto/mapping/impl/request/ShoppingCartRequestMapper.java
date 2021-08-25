package mate.academy.spring.service.dto.mapping.impl.request;

import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.request.ShoppingCartRequestDto;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartRequestMapper implements
        DtoRequestMapper<ShoppingCartRequestDto, ShoppingCart> {
    @Override
    public ShoppingCart fromDto(ShoppingCartRequestDto dto) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setTickets(dto.getTickets());
        shoppingCart.setUser(dto.getUser());
        return shoppingCart;
    }
}
