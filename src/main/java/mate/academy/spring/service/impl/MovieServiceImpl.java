package mate.academy.spring.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import mate.academy.spring.dao.MovieDao;
import mate.academy.spring.model.Movie;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieDao movieDao;

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public Movie get(Long id) {
        return movieDao.get(id).get();
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
