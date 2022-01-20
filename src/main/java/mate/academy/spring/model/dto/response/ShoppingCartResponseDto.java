package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> ticketIds;
    private UserResponseDto userResponseDto;

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

    public UserResponseDto getUser() {
        return userResponseDto;
    }

    public void setUser(UserResponseDto userResponseDto) {
        this.userResponseDto = userResponseDto;
    }
}
