package mate.academy.spring.model.dto.request;

import java.time.LocalDateTime;

public class MovieSessionRequestDto {
    private Long movieId;
    private LocalDateTime showTime;
    private Long cinemaHallId;

    public Long getMovieId() {
        return movieId;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public Long getCinemaHallId() {
        return cinemaHallId;
    }
}
