package mate.academy.spring.service;

import java.util.List;

public interface GenericService<T> {
    List<T> getAll();

    T add(T add);

    T get(Long id);

    T update(Long id);

    void delete(Long id);
}
