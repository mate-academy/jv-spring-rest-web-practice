package mate.academy.spring.model.dto.response;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UserResponseDto {
    private Long id;
    @NotNull
    @Email
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
