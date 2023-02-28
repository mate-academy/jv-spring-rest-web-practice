package mate.academy.spring.model.dto.response;

public class UserResponseDto {
    private Long id;
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

    @Override
    public String toString() {
        return String.format("UserResponseDto{id=%d, email='%s'}", id, email);
    }
}
