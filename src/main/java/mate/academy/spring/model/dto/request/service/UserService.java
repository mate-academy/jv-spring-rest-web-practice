package mate.academy.spring.model.dto.request.service;

import java.util.Optional;
import mate.academy.spring.model.User;

public interface UserService {
    User add(User user);

    Optional<User> findByEmail(String email);

    User get(Long id);
}
