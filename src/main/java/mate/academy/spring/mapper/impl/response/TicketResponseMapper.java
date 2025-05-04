package mate.academy.spring.mapper.impl.response;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.TicketResponseDto;
import org.springframework.stereotype.Component;

@Component
public class TicketResponseMapper implements DtoResponseMapper<TicketResponseDto,
        Ticket> {
    private final UserResponseMapper userResponseMapper;
    private final MovieSessionResponseMapper movieSessionResponseMapper;

    public TicketResponseMapper(UserResponseMapper userResponseMapper,
                                MovieSessionResponseMapper movieSessionResponseMapper) {
        this.userResponseMapper = userResponseMapper;
        this.movieSessionResponseMapper = movieSessionResponseMapper;
    }

    @Override
    public TicketResponseDto toDto(Ticket object) {
        TicketResponseDto dto = new TicketResponseDto();
        dto.setId(object.getId());

        dto.setUserResponseDto(userResponseMapper.toDto(object.getUser()));
        dto.setMovieSessionResponseDto(movieSessionResponseMapper.toDto(object.getMovieSession()));

        return dto;
    }
}
