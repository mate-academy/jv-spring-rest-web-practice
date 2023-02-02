package mate.academy.spring.model.dto.response;

import java.util.List;
import mate.academy.spring.model.Ticket;

public class ShoppingCartResponseDto {
    private List<Long> tickets;
    private Long userid;

    public List<Long> getTickets() {
        return tickets;
    }

    public void setTickets(List<Long> tickets) {
        this.tickets = tickets;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}
