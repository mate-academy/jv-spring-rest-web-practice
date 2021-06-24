package mate.academy.spring.model.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieSessionRequestDto {
    private Long movieId;
    private String showTime;
    private Long cinemaHallId;
}
