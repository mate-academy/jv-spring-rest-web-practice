package mate.academy.spring.model.dto.request;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class MovieSessionRequestDto {
    private Long movieId;
    private LocalDateTime showTime;
    private Long cinemaHallId;
}
