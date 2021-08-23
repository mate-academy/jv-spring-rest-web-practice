package mate.academy.spring.service.dto.mapping.impl.request;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import mate.academy.spring.service.TicketService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderRequestMapper implements DtoRequestMapper<OrderRequestDto, Order> {
    public static final String PATTERN = "dd.MM.yyyy HH:mm";
    private final UserService userService;
    private final TicketService ticketService;

    public OrderRequestMapper(UserService userService, TicketService ticketService) {
        this.userService = userService;
        this.ticketService = ticketService;
    }

    @Override
    public Order fromDto(OrderRequestDto dto) {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.parse(dto.getOrderDate(),
                DateTimeFormatter.ofPattern(PATTERN)));
        order.setUser(userService.findById(dto.getUserId()).get());
        List<Ticket> tikets = dto.getTickets().stream()
                .map(ticketService::findById)
                .map(Optional::get)
                .collect(Collectors.toList());
        order.setTickets(tikets);
        return order;
    }
}
