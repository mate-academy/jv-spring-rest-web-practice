package mate.academy.spring.model.dto.response;

public class UserResponseDto {
    private Long id;
    private String email;

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserResponseDto{"
                + " id=" + id
                + ", email='" + email + '\''
                + '}';
    }
}
