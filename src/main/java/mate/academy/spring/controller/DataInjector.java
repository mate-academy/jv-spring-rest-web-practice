package mate.academy.spring.controller;

import java.time.LocalDateTime;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.MovieSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inject")
public class DataInjector {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;
    private final MovieSessionService movieSessionService;

    @Autowired
    public DataInjector(MovieService movieService,
                        CinemaHallService cinemaHallService,
                        MovieSessionService movieSessionService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
        this.movieSessionService = movieSessionService;
    }

    @GetMapping
    public String injectData() {
        //--------Movies--------//
        Movie fastAndFurious = new Movie("Fast and Furious");
        fastAndFurious.setDescription("An action film about street racing, heists, and spies.");
        movieService.add(fastAndFurious);

        Movie interstellar = new Movie("Interstellar");
        interstellar.setDescription("When Earth becomes uninhabitable in the future, "
                + "a farmer and ex-NASA pilot, Joseph Cooper, is tasked to pilot a spacecraft, "
                + "along with a team of researchers, to find a new planet for humans.");
        movieService.add(interstellar);

        Movie tronLegacy = new Movie("Tron: Legacy");
        tronLegacy.setDescription("Sam misses his father, a virtual world designer, "
                + "and enters a virtual space that has become much "
                + "more dangerous than his father intended. Now, both "
                + "father and son embark upon a life-and-death journey.");
        movieService.add(tronLegacy);

        Movie inception = new Movie("Inception");
        inception.setDescription("Cobb steals information from his targets by entering "
                + "their dreams. Saito offers to wipe clean Cobb's criminal history "
                + "as payment for performing an inception on his sick competitor's son.");
        movieService.add(inception);

        //--------Cinema halls--------//
        CinemaHall redCinemaHall = new CinemaHall(50);
        redCinemaHall.setDescription("Red cinema hall with comfy chairs");
        cinemaHallService.add(redCinemaHall);

        CinemaHall greenCinemaHall = new CinemaHall(60);
        greenCinemaHall.setDescription("Green cinema hall with big screen chairs");
        cinemaHallService.add(greenCinemaHall);

        CinemaHall blueCinemaHall = new CinemaHall(70);
        blueCinemaHall.setDescription("blue cinema hall with comfy chairs, big screen and IMAX");
        cinemaHallService.add(blueCinemaHall);

        //--------Movie sessions--------//
        MovieSession movieSession1 = new MovieSession(interstellar, blueCinemaHall,
                LocalDateTime.now().plusMinutes(5).plusHours(3).plusDays(5));
        movieSessionService.add(movieSession1);

        MovieSession movieSession2 = new MovieSession(interstellar, blueCinemaHall,
                LocalDateTime.now().plusMinutes(10).plusHours(6).plusDays(5));
        movieSessionService.add(movieSession2);

        MovieSession movieSession3 = new MovieSession(inception, greenCinemaHall,
                LocalDateTime.now().plusMinutes(30).plusHours(5).plusDays(2));
        movieSessionService.add(movieSession3);

        MovieSession movieSession4 = new MovieSession(tronLegacy, blueCinemaHall,
                LocalDateTime.now().plusMinutes(15).plusHours(5).plusDays(5));
        movieSessionService.add(movieSession4);

        MovieSession movieSession5 = new MovieSession(fastAndFurious, redCinemaHall,
                LocalDateTime.now().plusMinutes(5).plusHours(5).plusDays(5));
        movieSessionService.add(movieSession5);
        return "Added mock data DB!";
    }
}
