package mate.academy.spring.controller;

import javax.validation.Valid;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.dto.mapping.impl.response.UserResponseDtoMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserResponseDtoMapper userResponseDtoMapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    UserResponseDtoMapper userResponseDtoMapper) {
        this.authenticationService = authenticationService;
        this.userResponseDtoMapper = userResponseDtoMapper;
    }

    @PostMapping
    @RequestMapping("/register")
    public UserResponseDto registration(@RequestBody @Valid UserRequestDto userRequestDto) {
        return userResponseDtoMapper.toDto(
               authenticationService.register(userRequestDto.getEmail(),
                       userRequestDto.getPassword()));
    }
}
