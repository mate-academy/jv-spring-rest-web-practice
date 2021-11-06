package mate.academy.spring.model.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserRequestDto {
    @NotBlank
    @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
    private String email;
    @NotBlank
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
