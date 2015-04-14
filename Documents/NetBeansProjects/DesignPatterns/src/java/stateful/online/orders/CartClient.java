package stateful.online.orders;

/**
 *
 * @author dsestak
 */
import java.util.Collection;
import java.util.Iterator;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class CartClient {

    public static void main(String[] blargs) throws NamingException {

        try {
            final Context context = getInitialContext();
            Cart cart = (Cart) context.lookup("zzz");

            System.out.println("Adding Basketball to cart.\n");
            Order order1 = new Order("Basketball", 10.00, 2);
            cart.addItem(order1);
            
            System.out.println("Adding Running Shoes to cart.\n");
            Order order2 = new Order("Running Shoes", 50.00, 1);
            cart.addItem(order2);

            System.out.println("Listing cart contents.....");
            Collection items = cart.getItems();
            for (Iterator i = items.iterator(); i.hasNext();) {
                Order item = (Order) i.next();
                System.out.println(item.toString());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static Context getInitialContext() throws NamingException {
        return new InitialContext();
    }
}
