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
    private final AuthenticationService authenticationService;
    private final DtoResponseMapper<UserResponseDto, User> userDtoResponseMapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    DtoResponseMapper<UserResponseDto, User>
                                            userDtoResponseMapper) {
        this.authenticationService = authenticationService;
        this.userDtoResponseMapper = userDtoResponseMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRequestDto userRequestDto) {
        return userDtoResponseMapper.toDto(authenticationService.register(userRequestDto.getEmail(),
                userRequestDto.getPassword()));
    }
}
