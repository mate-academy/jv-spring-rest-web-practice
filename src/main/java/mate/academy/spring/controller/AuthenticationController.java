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
    private final DtoResponseMapper<UserResponseDto, User> userDtoResponseMapper;
    private final AuthenticationService authenticationService;

    public AuthenticationController(DtoResponseMapper<UserResponseDto, User> userDtoResponseMapper,
                                    AuthenticationService authenticationService) {
        this.userDtoResponseMapper = userDtoResponseMapper;
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public UserResponseDto register(@RequestBody UserRequestDto userRequestDto) {
        User user = authenticationService.register(userRequestDto.getEmail(),
                userRequestDto.getPassword());
        return userDtoResponseMapper.toDto(user);
    }
}
