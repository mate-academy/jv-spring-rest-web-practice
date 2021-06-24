package mate.academy.spring.model.dto.request;

import lombok.Data;

@Data
public class MovieSessionRequestDto {
    private Long movieId;
    private String showTime;
    private Long cinemaHallId;
}
