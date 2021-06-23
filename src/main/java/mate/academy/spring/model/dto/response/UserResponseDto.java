package mate.academy.spring.model.dto.response;

public class UserResponseDto {
    private Long id;
    private String email;
    private String password;
    private byte[] salt;

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }
}
