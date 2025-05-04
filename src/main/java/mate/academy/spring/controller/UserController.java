package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
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
    private final DtoRequestMapper<UserRequestDto, User> userDtoRequestMapper;
    private final DtoResponseMapper<UserResponseDto, User> userDtoResponseMapper;

    public UserController(UserService userService,
                          DtoRequestMapper<UserRequestDto, User> userDtoRequestMapper,
                          DtoResponseMapper<UserResponseDto, User> userDtoResponseMapper
    ) {
        this.userService = userService;
        this.userDtoRequestMapper = userDtoRequestMapper;
        this.userDtoResponseMapper = userDtoResponseMapper;
    }

    @GetMapping("/by-email")//http://localhost:8080/users/by-email?email=vasya
    public UserResponseDto getUserByEmail(@RequestParam String email) {
        return userDtoResponseMapper.toDto(userService.findByEmail(email).get());
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.getAll().stream()
                .map(userDtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
