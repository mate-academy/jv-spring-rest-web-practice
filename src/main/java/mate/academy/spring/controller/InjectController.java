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
    private final AuthenticationService service;
    private final ShoppingCartService cartService;
    private final OrderService orderService;

    public InjectController(MovieService movieService, CinemaHallService cinemaHallService,
                            MovieSessionService movieSessionService, UserService userService,
                            AuthenticationService service, ShoppingCartService cartService,
                            OrderService orderService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
        this.movieSessionService = movieSessionService;
        this.userService = userService;
        this.service = service;
        this.cartService = cartService;
        this.orderService = orderService;
    }

    @GetMapping()
    public String injectData() {
        Movie fastAndFurious = new Movie("Fast and Furious");
        fastAndFurious.setDescription("An action film about street racing, heists, and spies.");
        movieService.add(fastAndFurious);
        System.out.println(movieService.get(fastAndFurious.getId()));
        movieService.getAll().forEach(System.out::println);

        CinemaHall firstCinemaHall = new CinemaHall();
        firstCinemaHall.setCapacity(100);
        firstCinemaHall.setDescription("first hall with capacity 100");

        CinemaHall secondCinemaHall = new CinemaHall();
        secondCinemaHall.setCapacity(200);
        secondCinemaHall.setDescription("second hall with capacity 200");

        cinemaHallService.add(firstCinemaHall);
        cinemaHallService.add(secondCinemaHall);

        MovieSession tomorrowMovieSession = new MovieSession();
        tomorrowMovieSession.setCinemaHall(firstCinemaHall);
        tomorrowMovieSession.setMovie(fastAndFurious);
        tomorrowMovieSession.setShowTime(LocalDateTime.now().plusDays(1L));

        MovieSession yesterdayMovieSession = new MovieSession();
        yesterdayMovieSession.setCinemaHall(firstCinemaHall);
        yesterdayMovieSession.setMovie(fastAndFurious);
        yesterdayMovieSession.setShowTime(LocalDateTime.now().minusDays(1L));

        movieSessionService.add(tomorrowMovieSession);
        movieSessionService.add(yesterdayMovieSession);

        User chris = service.register("Chris_Pain@gmail.com", "1478963");
        System.out.println(userService.findByEmail("Chris_Pain@gmail.com"));

        User veronica = service.register("Veronica_Porter@gmail.com", "ohjrlio");
        System.out.println(userService.findByEmail("Veronica_Porter@gmail.com"));

        cartService.addSession(tomorrowMovieSession, chris);
        cartService.addSession(tomorrowMovieSession, veronica);
        cartService.addSession(yesterdayMovieSession, chris);

        orderService.completeOrder(cartService.getByUser(chris));
        orderService.completeOrder(cartService.getByUser(veronica));
        return "All were injected!";
    }
}
