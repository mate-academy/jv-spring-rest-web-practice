package mate.academy.spring.model.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    @NotEmpty
    @NonNull
    @Size(min = 6, max = 100)
    private String email;
    @NotEmpty
    @NonNull
    @Size(min = 8, max = 30)
    private String password;
}
