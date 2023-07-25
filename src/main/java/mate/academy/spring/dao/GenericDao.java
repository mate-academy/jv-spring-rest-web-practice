package mate.academy.spring.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {
    T add(T entity);

    Optional<T> get(Long id);

    List<T> getAll();

    T update(T model);

    boolean delete(Long id);
}
