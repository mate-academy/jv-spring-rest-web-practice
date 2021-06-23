package mate.academy.spring.model.dto.response;

public class MovieSessionResponseDto {
    private Long id;
    private String movieTitle;
    private String showTime;
    private int cinemaHallCapacity;

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setShowTime(String showTime) {
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
