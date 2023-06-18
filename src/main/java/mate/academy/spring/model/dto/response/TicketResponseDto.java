package mate.academy.spring.model.dto.response;

public class TicketResponseDto {
    private Long id;
    private MovieSessionResponseDto movieSessionResponseDto;
    private UserResponseDto userResponseDto;

    public MovieSessionResponseDto getMovieSessionResponseDto() {
        return movieSessionResponseDto;
    }

    public void setMovieSessionResponseDto(MovieSessionResponseDto movieSessionResponseDto) {
        this.movieSessionResponseDto = movieSessionResponseDto;
    }

    public UserResponseDto getUserResponseDto() {
        return userResponseDto;
    }

    public void setUserResponseDto(UserResponseDto userResponseDto) {
        this.userResponseDto = userResponseDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
