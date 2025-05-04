package mate.academy.spring.mapper.impl.response;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.TicketResponseDto;
import org.springframework.stereotype.Component;

@Component
public class TicketResponseMapper implements DtoResponseMapper<TicketResponseDto, Ticket> {
    private final UserResponseMapper userResponseMapper;

    public TicketResponseMapper(UserResponseMapper userResponseMapper) {
        this.userResponseMapper = userResponseMapper;
    }

    @Override
    public TicketResponseDto toDto(Ticket ticket) {
        TicketResponseDto responseDto = new TicketResponseDto();
        responseDto.setTicketId(ticket.getId());
        responseDto.setUser(userResponseMapper.toDto(ticket.getUser()));
        responseDto.setTicketId(ticket.getId());
        return responseDto;
    }
}
