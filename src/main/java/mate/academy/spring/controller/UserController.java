package mate.academy.spring.controller;

import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.impl.response.UserResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;
    private final UserResponseMapper responseMapper;

    public UserController(UserService service, UserResponseMapper responseMapper) {
        this.service = service;
        this.responseMapper = responseMapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto getUserByEmail(@RequestParam String email) {
        return responseMapper.parseToDto(service.findByEmail(email).get());
    }
}
