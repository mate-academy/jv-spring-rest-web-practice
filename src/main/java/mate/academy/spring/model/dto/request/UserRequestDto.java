package mate.academy.spring.model.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRequestDto {
    @NotNull
    private String email;
    @NotNull
    @Size(min = 2)
    private String password;
    @NotNull
    @Size(min = 2)
    private String repeatPassword;

    public String getEmail() {
        return email;
    }

    public UserRequestDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRequestDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public UserRequestDto setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
        return this;
    }
}
