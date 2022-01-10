package mate.academy.spring.model.dto.request.service.dto.mapping.impl.request;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.request.MovieSessionRequestDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionRequestMapper implements DtoRequestMapper<MovieSessionRequestDto,
                                                                   MovieSession> {
    private static final String DATE_PATTERN = "dd.MM.yyyy HH:mm";
    private final CinemaHallService cinemaHallService;
    private final MovieService movieService;

    public MovieSessionRequestMapper(CinemaHallService cinemaHallService,
                                     MovieService movieService) {
        this.cinemaHallService = cinemaHallService;
        this.movieService = movieService;
    }

    @Override
    public MovieSession fromDto(MovieSessionRequestDto dto) {
        MovieSession movieSession = new MovieSession();
        Movie movie = movieService.get(dto.getMovieId());
        CinemaHall cinemaHall = cinemaHallService.get(dto.getCinemaHallId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
        movieSession.setMovie(movie);
        movieSession.setShowTime(LocalDateTime.parse(dto.getShowTime(), formatter));
        movieSession.setCinemaHall(cinemaHall);
        return movieSession;
    }
}
