package mate.academy.spring.config;

import java.time.LocalDateTime;
import javax.annotation.PostConstruct;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.User;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class AppInitializer {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;
    private final MovieSessionService movieSessionService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    public AppInitializer(MovieService movieService,
                          CinemaHallService cinemaHallService,
                          MovieSessionService movieSessionService,
                          ShoppingCartService shoppingCartService,
                          UserService userService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
        this.movieSessionService = movieSessionService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }

    @PostConstruct
    public String initialize() {
        Movie fastAndFurious = new Movie("Fast and Furious");
        fastAndFurious.setDescription("An action film about street racing, heists, and spies.");
        movieService.add(fastAndFurious);
        System.out.println(movieService.get(fastAndFurious.getId()));

        Movie cruella = new Movie("Cruella");
        cruella.setDescription("A new stunning film with brilliant actress Emma Stone!");
        movieService.add(cruella);
        System.out.println(movieService.get(cruella.getId()));

        movieService.getAll().forEach(System.out::println);

        CinemaHall redCinemaHall = new CinemaHall();
        redCinemaHall.setCapacity(200);
        redCinemaHall.setDescription("red cinema hall with capacity 200");

        CinemaHall blueCinemaHall = new CinemaHall();
        blueCinemaHall.setCapacity(100);
        blueCinemaHall.setDescription("blue cinema hall with capacity 100");

        cinemaHallService.add(redCinemaHall);
        cinemaHallService.add(blueCinemaHall);

        MovieSession tomorrowMovieSession = new MovieSession();
        tomorrowMovieSession.setCinemaHall(redCinemaHall);
        tomorrowMovieSession.setMovie(fastAndFurious);
        tomorrowMovieSession.setShowTime(LocalDateTime.now().plusDays(1L));

        MovieSession yesterdayMovieSession = new MovieSession();
        yesterdayMovieSession.setCinemaHall(redCinemaHall);
        yesterdayMovieSession.setMovie(fastAndFurious);
        yesterdayMovieSession.setShowTime(LocalDateTime.now().minusDays(1L));

        movieSessionService.add(tomorrowMovieSession);
        movieSessionService.add(yesterdayMovieSession);

        User bob = new User();
        bob.setEmail("bob@gmail.com");
        bob.setPassword("1234");
        userService.add(bob);
        String bobsEmail = "bob@gmail.com";
        System.out.println(userService.findByEmail(bobsEmail));

        User alice = new User();
        bob.setEmail("alice@gmail.com");
        bob.setPassword("1234");
        userService.add(alice);
        String aliceEmail = "bob@gmail.com";
        System.out.println(userService.findByEmail(aliceEmail));

        shoppingCartService.registerNewShoppingCart(bob);
        shoppingCartService.addSession(tomorrowMovieSession, bob);
        System.out.println(shoppingCartService.getByUser(bob));

        return "Initialized!";
    }
}
