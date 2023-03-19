package mate.academy.spring.mapper.impl.response;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.TicketResponseDto;
import org.springframework.stereotype.Component;

@Component
public class TicketsResponseMapper implements DtoResponseMapper<TicketResponseDto, Ticket> {

    @Override
    public TicketResponseDto toDto(Ticket ticket) {
        TicketResponseDto ticketResponseDto = new TicketResponseDto();
        ticketResponseDto.setId(ticket.getId());
        ticketResponseDto.setMovieSession(ticket.getMovieSession());
        ticketResponseDto.setUser(ticket.getUser());
        return ticketResponseDto;
    }
}
