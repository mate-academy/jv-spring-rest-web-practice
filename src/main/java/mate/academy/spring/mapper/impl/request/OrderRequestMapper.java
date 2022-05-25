package mate.academy.spring.mapper.impl.request;

import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import org.springframework.stereotype.Component;

@Component
public class OrderRequestMapper implements DtoRequestMapper<OrderRequestDto, Order> {

    private final TickerRequestMapper tickerRequestMapper;
    private final UserRequestMapper userRequestMapper;

    public OrderRequestMapper(TickerRequestMapper tickerRequestMapper,
                              UserRequestMapper userRequestMapper) {
        this.tickerRequestMapper = tickerRequestMapper;
        this.userRequestMapper = userRequestMapper;
    }

    @Override
    public Order fromDto(OrderRequestDto dto) {
        Order order = new Order();
        order.setId(dto.getOrderId());
        order.setOrderDate(dto.getOrderDate());
        order.setTickets(dto.getTickets()
                .stream()
                .map(tickerRequestMapper::fromDto)
                .collect(Collectors.toList()));
        order.setUser(userRequestMapper.fromDto(dto.getUser()));
        return order;
    }
}
