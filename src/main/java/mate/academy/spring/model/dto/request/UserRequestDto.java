package mate.academy.spring.model.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    @NotNull
    private String email;
    @NotNull
    @Size(min = 4, max = 20)
    private String password;
}
