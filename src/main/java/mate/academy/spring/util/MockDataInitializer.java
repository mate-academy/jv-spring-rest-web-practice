package mate.academy.spring.util;

import java.time.LocalDateTime;
import javax.annotation.PostConstruct;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.MovieSessionService;
import org.springframework.stereotype.Component;

@Component
public class MockDataInitializer {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;
    private final MovieSessionService movieSessionService;

    public MockDataInitializer(MovieService movieService,
            CinemaHallService cinemaHallService,
            MovieSessionService movieSessionService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
        this.movieSessionService = movieSessionService;
    }

    @PostConstruct
    public void inject() {
        Movie sherlock = new Movie("Sherlock", "Movie about Sherlock");
        Movie sherlock2 = new Movie("Sherlock 2", "Second movie about Sherlock");
        Movie sherlock3 = new Movie("Sherlock 3", "Third movie about Sherlock");
        movieService.add(sherlock);
        movieService.add(sherlock2);
        movieService.add(sherlock3);

        CinemaHall cinemaHall = new CinemaHall(100, "Capacity:100");
        CinemaHall cinemaHall2 = new CinemaHall(200, "Capacity:200");
        CinemaHall cinemaHall3 = new CinemaHall(300, "Capacity:300");
        cinemaHallService.add(cinemaHall);
        cinemaHallService.add(cinemaHall2);
        cinemaHallService.add(cinemaHall3);

        MovieSession movieSession = new MovieSession(sherlock, cinemaHall,
                LocalDateTime.of(2021, 6, 21, 12, 0));
        MovieSession movieSession2 = new MovieSession(sherlock2, cinemaHall2,
                LocalDateTime.now());
        MovieSession movieSession3 = new MovieSession(sherlock3, cinemaHall3,
                LocalDateTime.of(2021, 6, 23, 12, 0));
        movieSessionService.add(movieSession);
        movieSessionService.add(movieSession2);
        movieSessionService.add(movieSession3);
    }
}
