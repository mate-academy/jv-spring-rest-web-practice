package mate.academy.spring.model.dto.response;

public class CinemaHallResponseDto {
    private Long id;
    private int capacity;

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
