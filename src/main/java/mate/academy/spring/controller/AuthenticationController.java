package mate.academy.spring.controller;

import jakarta.validation.Valid;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private AuthenticationService service;
    private DtoResponseMapper<UserResponseDto, User> mapper;

    public AuthenticationController(AuthenticationService service,
                                    DtoResponseMapper<UserResponseDto, User> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/register")
    public UserResponseDto registration(@RequestBody @Valid UserRequestDto userRequestDto) {
        User user = service.register(userRequestDto.getEmail(), userRequestDto.getPassword());
        return mapper.toDto(user);
    }
}
