package mate.academy.spring.model.dto.response;

public class UserResponseDto {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserResponseDto{"
                + "id=" + id
                + '}';
    }
}
