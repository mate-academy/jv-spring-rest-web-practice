package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long idAndUserId;
    private List<Long> ticketsId;

    public List<Long> getTicketsId() {
        return ticketsId;
    }

    public void setTicketsId(List<Long> ticketsId) {
        this.ticketsId = ticketsId;
    }

    public Long getIdAndUserId() {
        return idAndUserId;
    }

    public void setIdAndUserId(Long idAndUserId) {
        this.idAndUserId = idAndUserId;
    }
}
