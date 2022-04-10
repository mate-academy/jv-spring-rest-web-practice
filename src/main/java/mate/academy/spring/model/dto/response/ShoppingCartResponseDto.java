package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> ticketIts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getTicketIts() {
        return ticketIts;
    }

    public void setTicketIts(List<Long> ticketIts) {
        this.ticketIts = ticketIts;
    }
}
