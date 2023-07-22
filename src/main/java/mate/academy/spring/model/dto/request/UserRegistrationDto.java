package mate.academy.spring.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import mate.academy.spring.validation.ValidPassword;
import org.hibernate.validator.constraints.UniqueElements;

@ValidPassword
public class UserRegistrationDto {
    @Email
    @NotNull
    @UniqueElements
    private String email;
    @NotNull
    private String password;
    @NotNull
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

    public void setPassword(String password) {
        this.password = password;
    }
}
