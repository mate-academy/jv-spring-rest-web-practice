package mate.academy.spring.model.dto.request.service;

import java.util.List;
import mate.academy.spring.model.CinemaHall;

public interface CinemaHallService {
    CinemaHall add(CinemaHall cinemaHall);

    CinemaHall get(Long id);

    List<CinemaHall> getAll();
}
