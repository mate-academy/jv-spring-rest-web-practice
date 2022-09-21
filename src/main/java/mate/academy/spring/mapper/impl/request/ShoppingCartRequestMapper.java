package mate.academy.spring.mapper.impl.request;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.ShoppingCartRequestDto;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartRequestMapper implements DtoRequestMapper<ShoppingCartRequestDto,
                                                                    ShoppingCart> {
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    public ShoppingCartRequestMapper(ShoppingCartService shoppingCartService,
                                     UserService userService) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }

    @Override
    public ShoppingCart fromDto(ShoppingCartRequestDto dto) {
        ShoppingCart shoppingCart = new ShoppingCart();
        User user = userService.get(dto.getUserId());
        shoppingCart.setUser(user);
        shoppingCart.setTickets(shoppingCartService.getByUser(user).getTickets());
        return shoppingCart;
    }
}
