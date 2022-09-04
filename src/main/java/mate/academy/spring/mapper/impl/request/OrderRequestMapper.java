package mate.academy.spring.mapper.impl.request;

import java.util.Optional;
import java.util.stream.Collectors;
import mate.academy.spring.dao.TicketDao;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import mate.academy.spring.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class OrderRequestMapper implements DtoRequestMapper<OrderRequestDto,
                                                                   Order> {
    private final UserService userService;
    private final TicketDao ticketDao;

    public OrderRequestMapper(UserService userService,
                              TicketDao ticketDao) {
        this.userService = userService;
        this.ticketDao = ticketDao;
    }

    @Override
    public Order fromDto(OrderRequestDto dto) {
        Order order = new Order();
        order.setTickets(dto.getTicketIds().stream()
                .map(ticketDao::get)
                .map(Optional::get)
                .collect(Collectors.toList()));
        order.setOrderDate(dto.getOrderDate());
        order.setUser(userService.get(dto.getUserId()));
        return order;
    }
}
