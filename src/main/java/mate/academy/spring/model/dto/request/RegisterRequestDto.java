package mate.academy.spring.model.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import mate.academy.spring.validation.Email;
import mate.academy.spring.validation.Password;

@Data
@Password
public class RegisterRequestDto {
    private static final int MIN_PASSWORD_LENGTH = 6;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Size(min = MIN_PASSWORD_LENGTH)
    private String password;
    @NotNull
    @Size(min = MIN_PASSWORD_LENGTH)
    private String repeatPassword;
}
