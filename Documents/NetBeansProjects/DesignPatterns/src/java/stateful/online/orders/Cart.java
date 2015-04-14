package stateful.online.orders;

/**
 *
 * @author dsestak
 */
import java.util.Collection;
import javax.ejb.Remote;
import javax.ejb.Remove;

@Remote
public interface Cart {
    public void addItem(Order order);
    @Remove
    public void removeItem(String item);
    public Collection getItems();
}