package mate.academy.spring.model.dto.request;

import mate.academy.spring.validation.EmailConstraint;
import mate.academy.spring.validation.ValidPassword;

@ValidPassword
public class UserRequestDto {
    @EmailConstraint
    private String email;
    private String password;
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
