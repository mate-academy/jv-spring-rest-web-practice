package mate.academy.spring.dao;

import java.util.Optional;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;

public interface ShoppingCartDao extends GenericDao<ShoppingCart> {
    Optional<ShoppingCart> getByUser(User user);

    void update(ShoppingCart shoppingCart);
}
