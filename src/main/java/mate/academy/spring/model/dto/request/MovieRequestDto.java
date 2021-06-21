package mate.academy.spring.model.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class MovieRequestDto {
    @NotNull
    @Size(min = 1, max = 255)
    private String title;
    @Size(max = 255)
    private String description;
}
