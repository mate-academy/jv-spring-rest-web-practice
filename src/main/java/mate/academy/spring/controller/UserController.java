package mate.academy.spring.controller;

import java.util.Optional;
import mate.academy.spring.exception.AuthenticationException;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final DtoResponseMapper<UserResponseDto, User> responseMapper;

    public UserController(UserService userService,
                          DtoResponseMapper<UserResponseDto, User> responseMapper) {
        this.userService = userService;
        this.responseMapper = responseMapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto getByEmail(@RequestParam String email) throws AuthenticationException {
        Optional<User> user = userService.findByEmail(email);
        if (user.isEmpty()) {
            throw new AuthenticationException("User by email: " + email + " doesn't exist.");
        }
        return responseMapper.toDto(user.get());
    }
}
