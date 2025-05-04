package mate.academy.spring.model.dto.request;

import lombok.Data;

@Data
public class UserRegistrationRequestDto {
    private String email;
    private String password;
}
