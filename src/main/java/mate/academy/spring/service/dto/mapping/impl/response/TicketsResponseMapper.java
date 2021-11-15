package mate.academy.spring.service.dto.mapping.impl.response;

import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.TicketResponseDto;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class TicketsResponseMapper implements DtoResponseMapper<TicketResponseDto, Ticket> {
    @Override
    public TicketResponseDto toDto(Ticket ticket) {
        TicketResponseDto ticketResponseDto = new TicketResponseDto();
        ticketResponseDto.setId(ticket.getId());
        ticketResponseDto.setUserId(ticket.getUser().getId());
        ticketResponseDto.setMovieSessionId(ticket.getMovieSession().getId());
        return ticketResponseDto;
    }
}
