package mate.academy.spring.mapper.impl.request;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.request.TicketRequestDto;
import org.springframework.stereotype.Component;

@Component
public class TickerRequestMapper implements DtoRequestMapper<TicketRequestDto, Ticket> {

    private final UserRequestMapper userRequestMapper;
    private final MovieSessionRequestMapper movieSessionRequestMapper;

    public TickerRequestMapper(UserRequestMapper userRequestMapper,
                               MovieSessionRequestMapper movieSessionRequestMapper) {
        this.userRequestMapper = userRequestMapper;
        this.movieSessionRequestMapper = movieSessionRequestMapper;
    }

    @Override
    public Ticket fromDto(TicketRequestDto dto) {
        Ticket ticket = new Ticket();
        ticket.setId(dto.getTicketId());
        ticket.setMovieSession(movieSessionRequestMapper.fromDto(dto.getMovieSession()));
        ticket.setUser(userRequestMapper.fromDto(dto.getUser()));
        return ticket;
    }
}
