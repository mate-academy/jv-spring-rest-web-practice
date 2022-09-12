package mate.academy.spring.model.dto.request;

import jakarta.validation.constraints.Min;

public class CinemaHallRequestDto {
    @Min(0)
    private int capacity;
    private String description;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
