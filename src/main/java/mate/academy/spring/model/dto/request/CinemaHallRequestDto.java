package mate.academy.spring.model.dto.request;

import org.springframework.lang.NonNull;

public class CinemaHallRequestDto {
    @NonNull
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
