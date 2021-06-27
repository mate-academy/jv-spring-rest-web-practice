package mate.academy.spring.model.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Data;
import mate.academy.spring.validation.Email;

@Data
public class UserRegistrationDto {
    @Email
    private String email;
    @Size(min = 8)
    private String password;
}
