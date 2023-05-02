package mate.academy.spring.model.dto.response;

import java.time.LocalDateTime;

public class MovieSessionResponseDto {
    private Long id;
    private final String title;
    private String movieTitle;
    private LocalDateTime showTime;
    private final int capacity;
    private int cinemaHallCapacity;

    public MovieSessionResponseDto(
            Long id,
            String title,
            LocalDateTime showTime,
            int capacity
    ) {
        this.id = id;
        this.title = title;
        this.showTime = showTime;
        this.capacity = capacity;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
