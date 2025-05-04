package mate.academy.spring.model.dto.response;

import mate.academy.spring.validation.Email;

public class UserResponseDto {
    private Long id;
    @Email
    private String email;

    public UserResponseDto() {
    }

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
