package mate.academy.spring.model.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import mate.academy.spring.validation.Email;

@Data
public class UserRegistrationDto {
    @Email
    private String email;
    @NotNull
    @Size(min = 8)
    private String password;
    @NotNull
    @Size(min = 8)
    private String repeatPassword;
}
