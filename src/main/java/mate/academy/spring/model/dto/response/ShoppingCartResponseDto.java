package mate.academy.spring.model.dto.response;

import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.User;

import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> ticketsIds;

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
}
