package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRegistrationRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService service;
    private final DtoResponseMapper<UserResponseDto, User> userDtoResponseMapper;

    public AuthenticationController(AuthenticationService service,
                                    DtoResponseMapper<UserResponseDto,
                                            User> userDtoResponseMapper) {
        this.service = service;
        this.userDtoResponseMapper = userDtoResponseMapper;
    }

    @PostMapping("/register")
    public UserResponseDto registration(@RequestBody UserRegistrationRequestDto requestDto) {
        return userDtoResponseMapper.toDto(
                service.register(requestDto.getEmail(), requestDto.getPassword()));
    }
}
