package stateful.online.orders;

/**
 *
 * @author dsestak
 */
import java.io.Serializable;

public class Order implements Serializable {
    public String name;
    public int quantity;
    public double price;
    
    public Order (String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    @Override
    public String toString() {
        return "Item Name: " + name + " Quantity: " + quantity + " Price: $" + getPrice();
    }
    
    private double getPrice () {return quantity * price;}
}
