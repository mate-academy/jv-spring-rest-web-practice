package mate.academy.spring.model.dto.response;

public class UserResponseDto {
    private Long id;
    private String email;

    public Long getId() {
        return id;
    }

    public UserResponseDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserResponseDto setEmail(String email) {
        this.email = email;
        return this;
    }
}
