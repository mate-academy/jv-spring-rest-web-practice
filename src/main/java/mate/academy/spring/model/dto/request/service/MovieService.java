package mate.academy.spring.model.dto.request.service;

import java.util.List;
import mate.academy.spring.model.Movie;

public interface MovieService {
    Movie add(Movie movie);

    Movie get(Long id);

    List<Movie> getAll();
}
