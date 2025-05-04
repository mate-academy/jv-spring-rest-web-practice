package mate.academy.spring.dao;

import java.util.List;
import java.util.Optional;
import mate.academy.spring.model.User;

public interface UserDao extends GenericDao<User> {
    User add(User user);

    Optional<User> findByEmail(String email);

    Optional<User> get(Long id);

    List<User> getAll();
}
