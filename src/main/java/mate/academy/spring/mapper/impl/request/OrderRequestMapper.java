package mate.academy.spring.mapper.impl.request;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.Order;

public class OrderRequestMapper implements DtoRequestMapper<OrderRequestMapper, Order> {
    @Override
    public Order fromDto(OrderRequestMapper dto) {
        return null;
    }
}
