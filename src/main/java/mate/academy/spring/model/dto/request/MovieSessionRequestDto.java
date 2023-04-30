package mate.academy.spring.model.dto.request;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieSessionRequestDto {
    private Long movieId;
    private LocalDateTime showTime;
    private Long cinemaHallId;
}
