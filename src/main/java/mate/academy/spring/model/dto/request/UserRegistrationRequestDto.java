package mate.academy.spring.model.dto.request;

import mate.academy.spring.service.validation.Email;
import mate.academy.spring.service.validation.Password;

public class UserRegistrationRequestDto {
    @Email
    private String email;
    @Password
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
