package mate.academy.spring.service;

import mate.academy.spring.model.User;

public interface UserService {
    User add(User user);

    User findByEmail(String email);

    User getById(Long id);
}
