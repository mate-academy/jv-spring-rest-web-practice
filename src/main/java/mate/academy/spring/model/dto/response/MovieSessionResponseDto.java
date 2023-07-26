package mate.academy.spring.model.dto.response;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieSessionResponseDto {
    private Long id;
    private String movieTitle;
    private LocalDateTime showTime;
    private int cinemaHallCapacity;
}
