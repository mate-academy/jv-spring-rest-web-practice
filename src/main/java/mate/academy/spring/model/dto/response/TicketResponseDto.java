package mate.academy.spring.model.dto.response;

public class TicketResponseDto {
    private Long ticketId;
    private MovieSessionResponseDto movieSession;
    private UserResponseDto user;

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public MovieSessionResponseDto getMovieSession() {
        return movieSession;
    }

    public void setMovieSession(MovieSessionResponseDto movieSession) {
        this.movieSession = movieSession;
    }

    public UserResponseDto getUser() {
        return user;
    }

    public void setUser(UserResponseDto user) {
        this.user = user;
    }
}
