package mate.academy.spring.model.dto.request;

import lombok.Getter;

@Getter
public class MovieSessionRequestDto {
    private Long movieId;
    private String showTime;
    private Long cinemaHallId;
}
