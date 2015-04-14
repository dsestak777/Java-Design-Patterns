package stateful.online.orders;

/**
 *
 * @author dsestak
 */
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful(name="CartBean")
@Remote(Cart.class)
public class CartBean implements Cart {
    private ArrayList<Order> items;

    @PostConstruct
    public void initialize() {
        items = new ArrayList<>();
    }
    
    public void addItem(Order order) {
        items.add(order);
    }

    @Remove
    public void removeItem(String item) {
        items.remove(item);
    }

    public Collection getItems() {
        return items;
    }
}