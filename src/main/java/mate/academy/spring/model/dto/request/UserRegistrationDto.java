package mate.academy.spring.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class UserRegistrationDto {
    @Email
    private String email;
    @NotNull
    private String password;
    private String repeatPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
}
