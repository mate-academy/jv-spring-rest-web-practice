package mate.academy.spring.service;

import java.util.Optional;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.UserResponseDto;

public interface UserService {
    User add(User user);

    Optional<User> findByEmail(String email);

    UserResponseDto getByEmail(String email);

    User get(Long id);
}
