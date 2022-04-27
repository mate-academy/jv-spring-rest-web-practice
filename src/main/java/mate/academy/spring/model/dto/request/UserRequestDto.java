package mate.academy.spring.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class UserRequestDto {
    @Email
    private String email;
    @Min(value = 6)
    private String password;
}
