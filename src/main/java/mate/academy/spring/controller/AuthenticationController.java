package mate.academy.spring.controller;

import javax.validation.Valid;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final DtoRequestMapper<UserRequestDto,User> dtoRequestMapper;
    private final DtoResponseMapper<UserResponseDto, User> dtoResponseMapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    DtoRequestMapper<UserRequestDto, User> dtoRequestMapper,
                                    DtoResponseMapper<UserResponseDto, User> dtoResponseMapper) {
        this.authenticationService = authenticationService;
        this.dtoRequestMapper = dtoRequestMapper;
        this.dtoResponseMapper = dtoResponseMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRequestDto dto) {

        User user = authenticationService.register(
                dtoRequestMapper.fromDto(dto).getEmail(),
                dtoRequestMapper.fromDto(dto).getPassword());
        return dtoResponseMapper.toDto(user);
    }
}
