package mate.academy.spring.model.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import org.springframework.lang.NonNull;

public class UserRequestDto {
    @NonNull
    @Email
    private String email;
    @NonNull
    @Size(8)
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
