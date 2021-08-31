package mate.academy.spring.service.injector;

import java.time.LocalDate;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitialDataInjector {
    private final CinemaHallService cinemaHallService;
    private final MovieService movieService;
    private final MovieSessionService movieSessionService;
    private final AuthenticationService authenticationService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    @PostConstruct
    private void injectInitialData() {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(150);
        cinemaHall.setDescription("Cinetech+");
        cinemaHallService.add(cinemaHall);
        cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(250);
        cinemaHall.setDescription("IMAX");
        cinemaHallService.add(cinemaHall);

        Movie movie = new Movie();
        movie.setTitle("American Beauty");
        movie.setDescription("drama");
        movieService.add(movie);
        movie = new Movie();
        movie.setTitle("007: Die Another Day");
        movie.setDescription("Action");
        movieService.add(movie);

        MovieSession session = new MovieSession();
        session.setMovie(movieService.get(1L));
        session.setCinemaHall(cinemaHallService.get(1L));
        session.setShowTime(LocalDate.now().atTime(16,45));
        movieSessionService.add(session);
        session = new MovieSession();
        session.setMovie(movieService.get(2L));
        session.setCinemaHall(cinemaHallService.get(2L));
        session.setShowTime(LocalDate.now().atTime(17,0));
        movieSessionService.add(session);
        session = new MovieSession();
        session.setMovie(movieService.get(1L));
        session.setCinemaHall(cinemaHallService.get(2L));
        session.setShowTime(LocalDate.now().atTime(19,5).plusDays(1));
        movieSessionService.add(session);
        session = new MovieSession();
        session.setMovie(movieService.get(2L));
        session.setCinemaHall(cinemaHallService.get(1L));
        session.setShowTime(LocalDate.now().atTime(14,15).minusDays(1));
        movieSessionService.add(session);

        authenticationService.register("bob@mail.com", "1111");
        authenticationService.register("alice@mail.com", "2222");

        shoppingCartService.addSession(movieSessionService.get(1L), userService.get(1L));
        shoppingCartService.addSession(movieSessionService.get(1L), userService.get(1L));
        shoppingCartService.addSession(movieSessionService.get(2L), userService.get(1L));
        shoppingCartService.addSession(movieSessionService.get(1L), userService.get(2L));
        shoppingCartService.addSession(movieSessionService.get(2L), userService.get(2L));
        shoppingCartService.addSession(movieSessionService.get(2L), userService.get(2L));
    }
}
