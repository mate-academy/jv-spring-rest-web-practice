package mate.academy.spring.model.dto.response;

import java.time.LocalDateTime;

public class MovieSessionResponseDto {
    private Long id;
    private String movieTitle;
    private LocalDateTime showTime;
    private int cinemaHallCapacity;

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    public void setCinemaHallCapacity(int cinemaHallCapacity) {
        this.cinemaHallCapacity = cinemaHallCapacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
