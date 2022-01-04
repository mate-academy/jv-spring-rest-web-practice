package mate.academy.spring.controller;

import javax.validation.Valid;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService service;
    private final DtoResponseMapper<UserResponseDto, User> responseMapper;

    public AuthenticationController(AuthenticationService service,
                                    DtoResponseMapper<UserResponseDto, User> responseMapper) {
        this.service = service;
        this.responseMapper = responseMapper;
    }

    @PostMapping("/register")
    public UserResponseDto registration(@RequestBody @Valid UserRequestDto dto) {
        User user = service.register(dto.getEmail(), dto.getPassword());
        return responseMapper.toDto(user);
    }
}
