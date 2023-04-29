package mate.academy.spring.model.dto.request;

import java.util.Arrays;

public class UserRequestDto {
    private String email;
    private String password;
    private byte[] salt;

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

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "UserRequestDto{"
                + "email='" + email + '\''
                + ", password='" + password + '\''
                + ", salt=" + Arrays.toString(salt)
                + '}';
    }
}
