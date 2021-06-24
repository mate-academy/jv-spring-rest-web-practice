package mate.academy.spring.controller;

import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.dto.mapping.impl.request.UserRequestMapper;
import mate.academy.spring.service.dto.mapping.impl.response.UserResponseMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthenticationController {
    private final UserResponseMapper responseMapper;
    private final UserRequestMapper requestMapper;

    public AuthenticationController(UserResponseMapper responseMapper,
                                    UserRequestMapper requestMapper) {
        this.responseMapper = responseMapper;
        this.requestMapper = requestMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto request) {
        return responseMapper.toDto(requestMapper.fromDto(request));
    }
}
