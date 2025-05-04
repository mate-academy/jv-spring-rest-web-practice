package mate.academy.spring.model.dto.request;

import java.util.List;

public class ShoppingCartRequestDto {
    private List<Long> ticketsId;
    private Long userid;

    public List<Long> getTicketsId() {
        return ticketsId;
    }

    public void setTicketsId(List<Long> ticketsId) {
        this.ticketsId = ticketsId;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}
