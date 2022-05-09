package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/users")
public class UserController {
    private UserService service;
    private DtoResponseMapper<UserResponseDto, User> mapper;

    public UserController(UserService service, DtoResponseMapper<UserResponseDto, User> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto findByEmail(@RequestParam String email) {
        User user = service.findByEmail(email).get();
        return mapper.toDto(user);
    }
}
