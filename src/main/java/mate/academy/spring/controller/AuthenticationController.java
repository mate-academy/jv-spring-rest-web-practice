package mate.academy.spring.controller;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class AuthenticationController {
    private final DtoResponseMapper<UserResponseDto, User> responseMapper;
    private final DtoRequestMapper<UserRequestDto, User> requestMapper;
    private final UserService userService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(DtoResponseMapper<UserResponseDto, User> responseMapper,
                                    DtoRequestMapper<UserRequestDto, User> requestMapper,
                                    UserService userService,
                                    AuthenticationService authenticationService) {
        this.responseMapper = responseMapper;
        this.requestMapper = requestMapper;
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public UserResponseDto completeOrder(@RequestBody UserRequestDto requestDto) {
        User user = authenticationService.register(requestDto.getEmail(), requestDto.getPassword());
        return responseMapper.toDto(user);
    }
}
