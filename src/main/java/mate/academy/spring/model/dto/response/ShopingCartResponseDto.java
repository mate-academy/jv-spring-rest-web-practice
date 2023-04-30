package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShopingCartResponseDto {
    private Long id;
    private List<Long> ticketIds;

    public ShopingCartResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getTicketIds() {
        return ticketIds;
    }

    public void setTicketIds(List<Long> ticketIds) {
        this.ticketIds = ticketIds;
    }
}
