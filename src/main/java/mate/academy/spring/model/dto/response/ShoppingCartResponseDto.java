package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> cartId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getCartId() {
        return cartId;
    }

    public void setCartId(List<Long> cartId) {
        this.cartId = cartId;
    }
}
