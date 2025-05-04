package mate.academy.spring.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "shopping_carts")
@Getter
@Setter
@ToString
public class ShoppingCart {
    @Id
    private Long id;
    @OneToMany
    private List<Ticket> tickets;
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;
}
