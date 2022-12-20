package mate.academy.spring.model.dto.response;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class MovieSessionResponseDto {
    private Long id;
    private String movieTitle;
    private LocalDateTime showTime;
    private int cinemaHallCapacity;
}
