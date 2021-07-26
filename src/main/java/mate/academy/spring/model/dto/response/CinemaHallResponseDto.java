package mate.academy.spring.model.dto.response;

import lombok.Data;

@Data
public class CinemaHallResponseDto {
    private Long id;
    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
