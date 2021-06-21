package mate.academy.spring.model.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class CinemaHallRequestDto {
    @NotNull
    @Min(value = 1)
    private int capacity;
    @Size(max = 255)
    private String description;
}
