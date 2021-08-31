package mate.academy.spring.controller;

import lombok.RequiredArgsConstructor;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
@RequiredArgsConstructor
public class ShoppingCartController {
    private final ShoppingCartService cartService;
    private final UserService userService;
    private final MovieSessionService sessionService;
    private final DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> responseMapper;

    @PutMapping
    public void addCartRecord(@RequestParam Long userId, @RequestParam Long movieSessionId) {
        cartService.addSession(sessionService.get(movieSessionId), userService.get(userId));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUserId(@RequestParam Long userId) {
        return responseMapper.toDto(cartService.getByUser(userService.get(userId)));
    }
}
