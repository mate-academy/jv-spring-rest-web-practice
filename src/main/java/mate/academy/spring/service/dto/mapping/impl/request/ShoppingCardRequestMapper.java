package mate.academy.spring.service.dto.mapping.impl.request;

import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.request.ShoppingCardRequestDto;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCardRequestMapper implements
        DtoRequestMapper<ShoppingCardRequestDto, ShoppingCart> {
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    public ShoppingCardRequestMapper(ShoppingCartService shoppingCartService,
                                     UserService userService) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }

    @Override
    public ShoppingCart fromDto(ShoppingCardRequestDto dto) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(userService.findByEmail(dto.getUserEmail()).get());
        shoppingCart.setTickets(shoppingCartService
                .getByUser(userService.findByEmail(dto.getUserEmail())
                        .get()).getTickets());
        return shoppingCart;
    }
}
