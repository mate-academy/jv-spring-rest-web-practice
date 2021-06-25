package mate.academy.spring.controller;

import java.time.LocalDateTime;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.User;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inject")
public class InjectController {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;
    private final MovieSessionService movieSessionService;
    private final UserService userService;
    private final AuthenticationService authenticationService;
    private final ShoppingCartService shoppingCartService;
    private final OrderService orderService;

    public InjectController(MovieService movieService, CinemaHallService cinemaHallService,
                            MovieSessionService movieSessionService,
                            UserService userService, AuthenticationService authenticationService,
                            ShoppingCartService shoppingCartService, OrderService orderService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
        this.movieSessionService = movieSessionService;
        this.userService = userService;
        this.authenticationService = authenticationService;
        this.shoppingCartService = shoppingCartService;
        this.orderService = orderService;
    }

    @GetMapping
    public String injectData() {
        CinemaHall redHall = new CinemaHall();
        redHall.setCapacity(25);
        redHall.setDescription("little hall");

        CinemaHall greenHall = new CinemaHall();
        greenHall.setCapacity(50);
        greenHall.setDescription("middle hall");

        cinemaHallService.add(redHall);
        cinemaHallService.add(greenHall);

        Movie terminator = new Movie();
        terminator.setTitle("Terminator 5");
        terminator.setDescription("Awesome movie");

        Movie avatar = new Movie();
        avatar.setTitle("Avatar");
        avatar.setDescription("Sci-fi movie");

        movieService.add(terminator);
        movieService.add(avatar);

        MovieSession firstMovieSession = new MovieSession();
        firstMovieSession.setMovie(avatar);
        firstMovieSession.setCinemaHall(redHall);
        firstMovieSession.setShowTime(LocalDateTime.now());

        MovieSession secondMovieSession = new MovieSession();
        secondMovieSession.setMovie(terminator);
        secondMovieSession.setCinemaHall(greenHall);
        secondMovieSession.setShowTime(LocalDateTime.now().plusDays(2));

        movieSessionService.add(firstMovieSession);
        movieSessionService.add(secondMovieSession);

        User bob = authenticationService.register("bob@gmail.com", "1234");
        shoppingCartService.addSession(firstMovieSession, bob);
        orderService.completeOrder(shoppingCartService.getByUser(bob));
        return "Added to DB!";
    }
}
