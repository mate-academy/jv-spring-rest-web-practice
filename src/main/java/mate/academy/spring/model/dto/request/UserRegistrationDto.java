package mate.academy.spring.model.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import mate.academy.spring.validation.ValidatePassword;

@ValidatePassword(password = "password",
        repeatedPassword = "repeatedPassword")
public class UserRegistrationDto {
    @Email
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String repeatedPassword;

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

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }
}
