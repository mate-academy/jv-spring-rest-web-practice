package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.request.CinemaHallRequestDto;
import mate.academy.spring.model.dto.response.CinemaHallResponseDto;
import mate.academy.spring.service.CinemaHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    // {"capacity":, "description":""}
    private CinemaHallService cinemaHallService;
    private DtoRequestMapper<CinemaHallRequestDto, CinemaHall> cinemaHallDtoRequestMapper;
    private DtoResponseMapper<CinemaHallResponseDto, CinemaHall> cinemaHallDtoResponseMapper;

    @PostMapping
    public CinemaHallResponseDto addCinemaHall(@RequestBody CinemaHallRequestDto dto) {
        CinemaHall cinemaHall = cinemaHallService.add(cinemaHallDtoRequestMapper.fromDto(dto));
        return cinemaHallDtoResponseMapper.toDto(cinemaHall);
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAllCinemaHalls() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallDtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Autowired
    public void setCinemaHallService(CinemaHallService cinemaHallService) {
        this.cinemaHallService = cinemaHallService;
    }

    @Autowired
    public void setCinemaHallDtoRequestMapper(DtoRequestMapper<CinemaHallRequestDto,
            CinemaHall> cinemaHallDtoRequestMapper) {
        this.cinemaHallDtoRequestMapper = cinemaHallDtoRequestMapper;
    }

    @Autowired
    public void setCinemaHallDtoResponseMapper(DtoResponseMapper<CinemaHallResponseDto,
            CinemaHall> cinemaHallDtoResponseMapper) {
        this.cinemaHallDtoResponseMapper = cinemaHallDtoResponseMapper;
    }
}
