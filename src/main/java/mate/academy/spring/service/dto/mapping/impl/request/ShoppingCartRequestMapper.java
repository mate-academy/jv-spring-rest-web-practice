package mate.academy.spring.service.dto.mapping.impl.request;

import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.request.ShoppingCartRequestDto;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartRequestMapper implements
        DtoRequestMapper<ShoppingCartRequestDto, ShoppingCart> {
    private final UserService userService;

    @Autowired
    public ShoppingCartRequestMapper(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ShoppingCart fromDto(ShoppingCartRequestDto dto) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(userService.get(dto.getUserId()));
        return shoppingCart;
    }
}
