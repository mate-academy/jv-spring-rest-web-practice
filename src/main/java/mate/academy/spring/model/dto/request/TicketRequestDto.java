package mate.academy.spring.model.dto.request;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.User;

public class TicketRequestDto {
    private MovieSession movieSession;
    private User user;

    public MovieSession getMovieSession() {
        return movieSession;
    }

    public void setMovieSession(MovieSession movieSession) {
        this.movieSession = movieSession;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
