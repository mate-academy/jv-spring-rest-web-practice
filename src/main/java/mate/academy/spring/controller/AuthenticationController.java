package mate.academy.spring.controller;

import javax.validation.Valid;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.AuthenticationUserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class AuthenticationController {
    private DtoResponseMapper<UserResponseDto, User> userDtoResponseMapper;
    private DtoRequestMapper<AuthenticationUserRequestDto, User> userDtoRequestMapper;
    private UserService userService;

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid AuthenticationUserRequestDto
                                                authenticationUserRequestDto) {
        return userDtoResponseMapper
                .toDto(userService
                        .add(userDtoRequestMapper
                                .fromDto(authenticationUserRequestDto)));
    }
}
