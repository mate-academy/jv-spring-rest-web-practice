package mate.academy.spring.model.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserRequestDto {
    private static final String EMAIL_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)"
            + "*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";
    private static final String message = "email is invalid";
    @Pattern(regexp = EMAIL_PATTERN, message = message)
    private String email;
    @NotNull
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
