package mate.academy.spring.mapper.impl.request;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.ShoppingCart;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartRequestMapper implements DtoRequestMapper<ShoppingCartRequestMapper,
        ShoppingCart> {
    @Override
    public ShoppingCart fromDto(ShoppingCartRequestMapper dto) {
        ShoppingCart shoppingCart = new ShoppingCart();

        return shoppingCart;
    }
}
