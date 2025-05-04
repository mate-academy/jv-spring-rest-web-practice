package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> ticketsId;
    private Long userid;

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

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}
