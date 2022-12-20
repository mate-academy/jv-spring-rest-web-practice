package mate.academy.spring.model.dto.request;

import java.time.LocalDateTime;
import javax.validation.constraints.NotEmpty;

public class MovieSessionRequestDto {
    @NotEmpty
    private Long movieId;
    @NotEmpty
    private LocalDateTime showTime;
    @NotEmpty
    private Long cinemaHallId;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }
}
