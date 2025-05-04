package mate.academy.spring.model.dto.request;

import javax.validation.constraints.NotNull;
import mate.academy.spring.validation.Email;

public class UserRequestDto {
    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;

    public UserRequestDto() {
    }

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
