package mate.academy.spring.model.dto.request;

import javax.validation.constraints.NotNull;
import mate.academy.spring.validator.Email;
import org.hibernate.validator.constraints.Length;

public class UserRequestDto {
    @NotNull
    @Email
    private String email;
    @NotNull
    @Length(min = 8)
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
