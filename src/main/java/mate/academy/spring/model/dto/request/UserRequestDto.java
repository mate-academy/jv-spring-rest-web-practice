package mate.academy.spring.model.dto.request;

import lombok.Data;
import mate.academy.spring.validation.Email;
import mate.academy.spring.validation.Password;

@Data
public class UserRequestDto {
    @Email
    private String email;
    @Password
    private String password;
}
