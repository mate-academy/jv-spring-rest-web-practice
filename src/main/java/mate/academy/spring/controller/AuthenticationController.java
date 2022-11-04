package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.UserDtoResponseMapper;
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
    private final UserDtoResponseMapper userDtoResponseMapper;

    public AuthenticationController(
            AuthenticationService authenticationService,
            UserDtoResponseMapper userDtoResponseMapper) {
        this.authenticationService = authenticationService;
        this.userDtoResponseMapper = userDtoResponseMapper;
    }

    @PostMapping("/register")
    public UserResponseDto registration(@RequestBody UserRequestDto userRequestDto) {
        User user = authenticationService.register(userRequestDto.getEmail(),
                userRequestDto.getPassword());
        return userDtoResponseMapper.toDto(user);
    }
}
