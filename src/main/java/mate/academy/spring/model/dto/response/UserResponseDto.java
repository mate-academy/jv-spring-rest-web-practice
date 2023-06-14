package mate.academy.spring.model.dto.response;

import org.springframework.stereotype.Component;

@Component
public class UserResponseDto {
    private String email;
    private Long id;

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
