package mate.academy.spring.service.dto.mapping.impl.response;

import java.time.format.DateTimeFormatter;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.response.MovieSessionResponseDto;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionResponseMapper implements DtoResponseMapper<MovieSessionResponseDto,
        MovieSession> {
    @Override
    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto movieSessionResponseDto = new MovieSessionResponseDto();
        movieSessionResponseDto.setId(movieSession.getId());
        movieSessionResponseDto.setMovieTitle(movieSession.getMovie().getTitle());
        movieSessionResponseDto.setShowTime(movieSession.getShowTime()
                .format(DateTimeFormatter
                        .ofPattern("dd.MM.yyyy HH:mm")));
        movieSessionResponseDto.setCinemaHallCapacity(movieSession.getCinemaHall().getCapacity());
        return movieSessionResponseDto;
    }
}
