package mate.academy.spring.controller;

import javax.persistence.EntityNotFoundException;
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
    private final UserResponseMapper dtoResponseMapper;

    public UserController(UserService userService, UserResponseMapper dtoResponseMapper) {
        this.userService = userService;
        this.dtoResponseMapper = dtoResponseMapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto getUserByEmail(@RequestParam String email) {
        User userFromDb = userService.findByEmail(email).orElseThrow(
                () -> new EntityNotFoundException(
                        String.format("Can't find user in DB by %s", email)));
        return dtoResponseMapper.toDto(userFromDb);
    }
}
