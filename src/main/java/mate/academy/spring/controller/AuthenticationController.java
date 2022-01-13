package mate.academy.spring.controller;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final DtoResponseMapper<UserResponseDto, User> dtoResponseMapper;
    private final DtoRequestMapper<UserRequestDto, User> dtoRequestMapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    DtoResponseMapper<UserResponseDto, User> dtoResponseMapper,
                                    DtoRequestMapper<UserRequestDto, User> dtoRequestMapper) {
        this.authenticationService = authenticationService;
        this.dtoResponseMapper = dtoResponseMapper;
        this.dtoRequestMapper = dtoRequestMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto userRequestDto) {
        User registeredUser = authenticationService.register(
                userRequestDto.getEmail(),
                userRequestDto.getPassword()
        );
        return dtoResponseMapper.toDto(registeredUser);

    }
}
