package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.request.CinemaHallRequestDto;
import mate.academy.spring.model.dto.response.CinemaHallResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final DtoRequestMapper<CinemaHallRequestDto, CinemaHall> requestMapper;
    private final DtoResponseMapper<CinemaHallResponseDto, CinemaHall> responseMapper;

    public CinemaHallController(CinemaHallService cinemaHallService,
                                DtoRequestMapper<CinemaHallRequestDto, CinemaHall>
                                        requestMapper,
                                DtoResponseMapper<CinemaHallResponseDto, CinemaHall>
                                        responseMapper) {
        this.cinemaHallService = cinemaHallService;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
    }

    @PostMapping
    public CinemaHallResponseDto addCinemaHall(@RequestBody CinemaHallRequestDto dto) {
        CinemaHall cinemaHall = cinemaHallService.add(requestMapper.fromDto(dto));
        return responseMapper.toDto(cinemaHall);
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAllCinemaHalls() {
        return cinemaHallService.getAll().stream()
                .map(responseMapper::toDto)
                .collect(Collectors.toList());
    }
}
