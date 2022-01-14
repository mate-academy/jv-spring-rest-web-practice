package mate.academy.spring.controller;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.AuthenticationRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final DtoResponseMapper<UserResponseDto, User> userDtoMapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    DtoResponseMapper<UserResponseDto,
                                            User> userDtoMapper) {
        this.authenticationService = authenticationService;
        this.userDtoMapper = userDtoMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(
            @RequestBody AuthenticationRequestDto authenticationRequestDto) {
        User user = authenticationService.register(authenticationRequestDto.getEmail(),
                authenticationRequestDto.getPassword());
        return userDtoMapper.toDto(user);
    }
}
