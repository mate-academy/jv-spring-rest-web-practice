package mate.academy.spring.controller;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.AuthenticationRequestDto;
import mate.academy.spring.model.dto.response.AuthenticationResponseDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final DtoResponseMapper<AuthenticationResponseDto, User> userDtoMapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    DtoResponseMapper<AuthenticationResponseDto,
                                            User> authenticationDtoMapper) {
        this.authenticationService = authenticationService;
        this.userDtoMapper = authenticationDtoMapper;
    }

    @PostMapping("/register")
    public AuthenticationResponseDto register(
            @RequestBody AuthenticationRequestDto authenticationRequestDto) {
        User user = authenticationService.register(authenticationRequestDto.getEmail(),
                authenticationRequestDto.getPassword());
        return userDtoMapper.toDto(user);
    }
}
