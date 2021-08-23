package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShoppingCcartResponseDto {
    private Long id;
    private List<Long> ticketsId;

    public ShoppingCcartResponseDto(Long id, List<Long> ticketsId) {
        this.id = id;
        this.ticketsId = ticketsId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getTicketsId() {
        return ticketsId;
    }

    public void setTicketsId(List<Long> ticketsId) {
        this.ticketsId = ticketsId;
    }
}
