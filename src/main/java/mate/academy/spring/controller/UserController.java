package mate.academy.spring.controller;

import jakarta.validation.constraints.Email;
import mate.academy.spring.exception.DataProcessingException;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;
    private final DtoResponseMapper<UserResponseDto, User> mapper;

    @Autowired
    public UserController(DtoResponseMapper<UserResponseDto, User> mapper,
                          UserService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping("/by-email")
    public UserResponseDto getByEmail(@RequestParam @Email String email) {
        return mapper.toDto(service.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email " + email + " is wrong!")));
    }
}
