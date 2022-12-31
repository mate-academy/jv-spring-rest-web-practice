package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDto register(@RequestBody UserRequestDto requestDto) {
        User user = authenticationService.register(requestDto.getEmail(),
                requestDto.getPassword());
        return userDtoResponseMapper.toDto(user);
    }
}
