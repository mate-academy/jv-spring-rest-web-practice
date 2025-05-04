package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShoppingCardResponseDto {
    private Long id;
    private List<Long> ticketsIds;

    public ShoppingCardResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getTicketsIds() {
        return ticketsIds;
    }

    public void setTicketsIds(List<Long> ticketsIds) {
        this.ticketsIds = ticketsIds;
    }

    @Override
    public String toString() {
        return "ShoppingCardDto{"
                + "id=" + id
                + ", ticketsIds=" + ticketsIds
                + '}';
    }
}
