package mate.academy.spring.dao;

import java.util.List;
import mate.academy.spring.model.Order;

public interface OrderDao extends GenericDao<Order> {
    List<Order> getOrdersHistory(Long userId);
}
