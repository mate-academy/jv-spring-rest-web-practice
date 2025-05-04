package mate.academy.spring.service;

import java.util.Optional;
import mate.academy.spring.model.User;

public interface UserService {
    Optional<User> findByEmail(String email);

    User get(Long id);
}
