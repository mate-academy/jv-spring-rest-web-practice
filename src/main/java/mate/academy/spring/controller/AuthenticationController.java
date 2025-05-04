package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private DtoRequestMapper<UserRequestDto, User> userRequestMapper;
    private DtoResponseMapper<UserResponseDto, User> userResponseMapper;
    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(DtoRequestMapper<UserRequestDto, User> userRequestMapper,
                                    DtoResponseMapper<UserResponseDto, User> userResponseMapper,
                                    AuthenticationService authenticationService) {
        this.userRequestMapper = userRequestMapper;
        this.userResponseMapper = userResponseMapper;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto userRequestDto) {
        User userFromDto = userRequestMapper.fromDto(userRequestDto);
        User user = authenticationService.register(userFromDto.getEmail(),
                userFromDto.getPassword());
        return userResponseMapper.toDto(user);
    }
}
