package mate.academy.spring.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    @NotNull
    private String email;
    @NotNull
    @Min(4)
    private String password;
}
