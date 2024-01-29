package mate.academy.spring.model.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UserRequestDto {
    @NotNull
    private String email;
    @NotNull
    @Min(6)
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
