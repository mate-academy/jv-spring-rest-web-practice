package mate.academy.spring.model.dto.request;

public class TicketRequestDto {
    private Long ticketId;
    private MovieSessionRequestDto movieSession;
    private UserRequestDto user;

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public MovieSessionRequestDto getMovieSession() {
        return movieSession;
    }

    public void setMovieSession(MovieSessionRequestDto movieSession) {
        this.movieSession = movieSession;
    }

    public UserRequestDto getUser() {
        return user;
    }

    public void setUser(UserRequestDto user) {
        this.user = user;
    }
}
