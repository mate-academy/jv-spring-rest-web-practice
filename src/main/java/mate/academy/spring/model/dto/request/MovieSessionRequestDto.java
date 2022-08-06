package mate.academy.spring.model.dto.request;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

public class MovieSessionRequestDto {
    @NotNull
    private Long movieId;
    @NotNull
    private LocalDateTime showTime;
    @NotNull
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
