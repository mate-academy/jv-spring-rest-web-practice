package mate.academy.spring.model.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MovieSessionRequestDto {
    @NotNull
    private Long movieId;
    @NotNull
    private String showTime;
    @NotNull
    private Long cinemaHallId;
}
