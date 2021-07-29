package mate.academy.spring.dao;

import mate.academy.spring.model.ShoppingCart;

public interface ShoppingCartDao extends GenericDao<ShoppingCart> {
    ShoppingCart getByUserId(Long userId);

    void update(ShoppingCart shoppingCart);
}
