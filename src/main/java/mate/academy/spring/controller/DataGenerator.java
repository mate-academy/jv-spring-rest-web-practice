package mate.academy.spring.controller;

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
public class DataGenerator {
    private final CinemaHallService cinemaHallService;
    private final MovieService movieService;
    private final MovieSessionService movieSessionService;

    public DataGenerator(CinemaHallService cinemaHallService,
                         MovieService movieService, MovieSessionService movieSessionService) {
        this.cinemaHallService = cinemaHallService;
        this.movieService = movieService;
        this.movieSessionService = movieSessionService;
    }

    @PostConstruct
    public void injectMockData() {
        CinemaHall bigHall = new CinemaHall();
        bigHall.setCapacity(1000);
        bigHall.setDescription("Very big hall!");
        cinemaHallService.add(bigHall);
        CinemaHall smallHall = new CinemaHall();
        smallHall.setCapacity(10);
        smallHall.setDescription("Very small hall");
        cinemaHallService.add(smallHall);

        Movie funnyMovie = new Movie();
        funnyMovie.setTitle("Funny movie");
        funnyMovie.setDescription("Very funny movie!");
        movieService.add(funnyMovie);
        Movie scaryMovie = new Movie();
        scaryMovie.setTitle("Scary movie");
        scaryMovie.setDescription("Very scary movie!");
        movieService.add(scaryMovie);

        MovieSession todaySession = new MovieSession();
        todaySession.setMovie(funnyMovie);
        todaySession.setShowTime(LocalDateTime.now());
        todaySession.setCinemaHall(bigHall);
        movieSessionService.add(todaySession);
        MovieSession tomorrowSession = new MovieSession();
        tomorrowSession.setMovie(scaryMovie);
        tomorrowSession.setShowTime(LocalDateTime.now().plusDays(1));
        tomorrowSession.setCinemaHall(smallHall);
        movieSessionService.add(tomorrowSession);
    }
}
