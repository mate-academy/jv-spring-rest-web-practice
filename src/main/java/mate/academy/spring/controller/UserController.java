package mate.academy.spring.controller;

import java.util.Optional;
import mate.academy.spring.model.User;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/by-email")
    public User getByEmail(@RequestParam String email) {
        Optional<User> userOptional = userService.findByEmail(email);
        return userOptional.orElseThrow(
            () -> new RuntimeException("User not found by email: " + email));
    }
}
