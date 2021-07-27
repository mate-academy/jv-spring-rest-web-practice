package mate.academy.spring.model.dto.request;

import lombok.Data;
import mate.academy.spring.validation.Email;
import mate.academy.spring.validation.ValidPassword;

@Data
public class UserRequestDto {
    @Email
    private String email;
    @ValidPassword
    private String password;
}
