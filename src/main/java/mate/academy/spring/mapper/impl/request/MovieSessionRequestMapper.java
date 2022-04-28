package mate.academy.spring.mapper.impl.request;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.request.MovieSessionRequestDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionRequestMapper implements DtoRequestMapper<MovieSessionRequestDto,
                                                                   MovieSession> {
    private final CinemaHallService cinemaHallService;
    private final MovieService movieService;

    public MovieSessionRequestMapper(CinemaHallService cinemaHallService,
                                     MovieService movieService) {
        this.cinemaHallService = cinemaHallService;
        this.movieService = movieService;
    }

    @Override
    public MovieSession toModel(MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        Movie movie = movieService.get(movieSessionRequestDto.getMovieId());
        CinemaHall cinemaHall = cinemaHallService.get(movieSessionRequestDto.getCinemaHallId());
        movieSession.setMovie(movie);
        movieSession.setShowTime(movieSessionRequestDto.getShowTime());
        movieSession.setCinemaHall(cinemaHall);
        return movieSession;
    }
}
