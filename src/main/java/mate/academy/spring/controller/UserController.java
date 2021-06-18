package mate.academy.spring.controller;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/users")
public class UserController {
    private final UserService userService;
    private final DtoResponseMapper<UserResponseDto, User> dtoResponseMapper;

    public UserController(UserService userService, DtoResponseMapper<UserResponseDto, User> dtoResponseMapper) {
        this.userService = userService;
        this.dtoResponseMapper = dtoResponseMapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto getUserByEmail(@RequestBody String email) {
        User user = userService.findByEmail(email).get();
        return dtoResponseMapper.toDto(user);
    }
}
