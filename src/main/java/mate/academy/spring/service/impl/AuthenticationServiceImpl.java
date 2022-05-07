package mate.academy.spring.service.impl;

import mate.academy.spring.exception.RegistrationException;
import mate.academy.spring.model.User;
import mate.academy.spring.service.AuthenticationService;
import mate.academy.spring.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private UserService userService;

    public AuthenticationServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User register(String email, String password) throws RegistrationException {
        if (userService.findByEmail(email).isPresent()) {
            throw new RegistrationException("Email " + email + "is already used");
        }
        User user = new User();
        user.setEmail(email);
        return userService.add(user);
    }
}
