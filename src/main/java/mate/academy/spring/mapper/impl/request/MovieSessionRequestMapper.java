package mate.academy.spring.mapper.impl.request;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.request.MovieSessionRequestDto;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionRequestMapper
    implements DtoRequestMapper<MovieSessionRequestDto, MovieSession> {
    @Override
    public MovieSession fromDto(MovieSessionRequestDto dto) {
        MovieSession movieSession = new MovieSession();
        Movie movie = new Movie();
        movie.setId(dto.getMovieId());
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setId(dto.getCinemaHallId());
        movieSession.setMovie(movie);
        movieSession.setShowTime(dto.getShowTime());
        movieSession.setCinemaHall(cinemaHall);
        return movieSession;
    }
}
