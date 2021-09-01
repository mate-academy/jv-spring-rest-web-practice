package mate.academy.spring.dao;

import java.util.Optional;
import mate.academy.spring.model.User;

public interface UserDao extends GenericDao<User> {
    Optional<User> getById(Long id);

    Optional<User> findByEmail(String email);

    Optional<User> get(Long id);
}
