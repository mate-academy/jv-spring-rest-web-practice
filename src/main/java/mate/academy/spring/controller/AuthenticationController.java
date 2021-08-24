package mate.academy.spring.controller;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class AuthenticationController {
    private final AuthenticationService service;
    private final DtoResponseMapper<UserResponseDto, User> mapper;

    public AuthenticationController(AuthenticationService service,
                                    DtoResponseMapper<UserResponseDto, User> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public UserResponseDto register(@RequestBody UserRequestDto dto) {
        User user = service.register(dto.getEmail(), dto.getPassword());
        return mapper.toDto(user);
    }
}
