package mate.academy.spring.model.dto.response;

import java.util.List;

public class OrderResponseDto {
    private Long id;
    private List<Long> ticketsIds;

    public List<Long> getTicketsIds() {
        return ticketsIds;
    }

    public void setTicketsIds(List<Long> ticketsIds) {
        this.ticketsIds = ticketsIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
