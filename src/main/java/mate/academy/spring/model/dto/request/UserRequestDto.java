package mate.academy.spring.model.dto.request;

public class UserRequestDto {
    private final String email;
    private final String password;

    public UserRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
