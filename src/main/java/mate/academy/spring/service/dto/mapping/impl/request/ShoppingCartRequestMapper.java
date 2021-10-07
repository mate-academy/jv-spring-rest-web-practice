package mate.academy.spring.service.dto.mapping.impl.request;

import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.request.ShoppingCartRequestDto;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;

public class ShoppingCartRequestMapper implements DtoRequestMapper<ShoppingCartRequestDto, ShoppingCart> {
    private final UserService userService;

    public ShoppingCartRequestMapper(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ShoppingCart fromDto(ShoppingCartRequestDto shoppingCartRequestDto) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setTickets(shoppingCartRequestDto.getTickets());
        shoppingCart.setUser(userService.get(shoppingCartRequestDto.getUserId()));
        return shoppingCart;
    }
}
