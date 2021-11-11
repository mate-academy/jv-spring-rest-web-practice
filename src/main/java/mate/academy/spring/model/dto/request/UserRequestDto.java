package mate.academy.spring.model.dto.request;

import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;

public class UserRequestDto {
    @NonNull
    @Size(min = 5)
    private String email;
    @NonNull
    @Size(min = 5)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
