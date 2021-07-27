package mate.academy.spring.model.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MovieSessionRequestDto {
    @NotNull
    @Min(value = 0)
    private Long movieId;
    @NotNull
    private String showTime;
    @NotNull
    @Min(value = 0)
    private Long cinemaHallId;
}
