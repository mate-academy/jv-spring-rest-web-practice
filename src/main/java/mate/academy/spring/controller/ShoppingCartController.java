package mate.academy.spring.controller;

import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> shoppingCartDtoResponseMapper;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart>
                                          shoppingCartDtoResponseMapper) {
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartDtoResponseMapper = shoppingCartDtoResponseMapper;
    }
}
