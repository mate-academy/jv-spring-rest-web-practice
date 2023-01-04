package mate.academy.spring.model.dto.request;

import org.springframework.lang.NonNull;

public class UserRequestDto {
    @NonNull
    private String email;
    @NonNull
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
