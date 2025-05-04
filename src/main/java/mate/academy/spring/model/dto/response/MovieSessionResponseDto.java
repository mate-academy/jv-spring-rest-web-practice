package mate.academy.spring.model.dto.response;

import java.time.LocalDateTime;

public class MovieSessionResponseDto {
    private Long id;
    private String movieTitle;
    private LocalDateTime showTime;
    private int cinemaHallCapacity;

    public MovieSessionResponseDto(Long id,
                                   String movieTitle,
                                   LocalDateTime showTime,
                                   int cinemaHallCapacity) {
        this.id = id;
        this.movieTitle = movieTitle;
        this.showTime = showTime;
        this.cinemaHallCapacity = cinemaHallCapacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    public int getCinemaHallCapacity() {
        return cinemaHallCapacity;
    }

    public void setCinemaHallCapacity(int cinemaHallCapacity) {
        this.cinemaHallCapacity = cinemaHallCapacity;
    }
}
