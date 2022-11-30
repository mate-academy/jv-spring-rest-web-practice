package mate.academy.spring.model.dto.request;

import javax.persistence.Column;
import mate.academy.spring.validation.EmailValidation;
import mate.academy.spring.validation.PasswordValidation;

@PasswordValidation
public class UserRequestDto {
    @EmailValidation
    private String email;
    private String password;
    private String repeatPassword;
    private byte[] salt;

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

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }
}
