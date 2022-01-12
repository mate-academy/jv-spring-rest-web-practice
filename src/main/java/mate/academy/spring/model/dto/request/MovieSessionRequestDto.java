package mate.academy.spring.model.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieSessionRequestDto {
    @NotNull
    private Long movieId;
    @NotNull
    private String showTime;
    @NotNull
    private Long cinemaHallId;
}
