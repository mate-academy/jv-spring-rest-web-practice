package mate.academy.spring.model.dto.request;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    @NotNull
    private String email;
    @NotNull
    private String password;
}
