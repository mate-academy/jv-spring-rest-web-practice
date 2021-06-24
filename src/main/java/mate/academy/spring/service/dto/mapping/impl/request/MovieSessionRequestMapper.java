package mate.academy.spring.service.dto.mapping.impl.request;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.request.MovieSessionRequestDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionRequestMapper
        implements DtoRequestMapper<MovieSessionRequestDto, MovieSession> {
    public static final String PATTERN = "dd.MM.yyyy HH:mm";
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
        movieSession.setMovie(movieService.get(dto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(dto.getCinemaHallId()));
        movieSession.setShowTime(LocalDateTime.parse(dto.getShowTime(),
                DateTimeFormatter.ofPattern(PATTERN)));
        return movieSession;
    }
}
