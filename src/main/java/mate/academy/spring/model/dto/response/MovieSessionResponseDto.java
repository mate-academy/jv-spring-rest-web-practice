package mate.academy.spring.model.dto.response;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class MovieSessionResponseDto {
    private Long id;
    private String movieTitle;
    private LocalDateTime showTime;
    private int cinemaHallCapacity;
}
