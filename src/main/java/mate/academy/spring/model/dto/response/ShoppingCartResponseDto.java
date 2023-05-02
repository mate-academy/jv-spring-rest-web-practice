package mate.academy.spring.model.dto.response;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
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
