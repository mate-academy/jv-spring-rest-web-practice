package mate.academy.spring.service;

import java.util.List;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.ShoppingCart;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(Long userId);
}
