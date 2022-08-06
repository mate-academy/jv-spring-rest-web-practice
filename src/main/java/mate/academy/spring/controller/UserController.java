package mate.academy.spring.controller;

import java.util.Optional;
import mate.academy.spring.mapper.impl.response.UserResponseMapper;
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
    private final UserResponseMapper responseMapper;

    public UserController(UserService userService, UserResponseMapper responseMapper) {
        this.userService = userService;
        this.responseMapper = responseMapper;
    }

    //Get user by email - GET: /users/by-email?email
    @GetMapping("/by-email")
    public UserResponseDto findUserByEmail(@RequestParam String email) {
        Optional<User> user = userService.findByEmail(email);
        if (user.isPresent()) {
            return responseMapper.toDto(user.get());
        }
        //CurrentlyCreationException
        return null;
    }
}
