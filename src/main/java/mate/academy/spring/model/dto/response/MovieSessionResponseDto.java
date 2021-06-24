package mate.academy.spring.model.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieSessionResponseDto {
    private Long id;
    private String movieTitle;
    private String showTime;
    private int cinemaHallCapacity;
}
