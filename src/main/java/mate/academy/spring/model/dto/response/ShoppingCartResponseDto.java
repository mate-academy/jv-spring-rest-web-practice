package mate.academy.spring.model.dto.response;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> ticketsId;

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
