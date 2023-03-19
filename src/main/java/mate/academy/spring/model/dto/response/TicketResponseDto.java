package mate.academy.spring.model.dto.response;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.User;

public class TicketResponseDto {

    private Long id;

    private MovieSession movieSession;

    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
