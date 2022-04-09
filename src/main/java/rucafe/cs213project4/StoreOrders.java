package rucafe.cs213project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 *
 * @author Mark Holleran, Abhitej Bokka
 */
public class StoreOrders implements Customizable{

    private ObservableList<Order> orders;


    /**
     * Default constructor for creating a StoreOrders Object
     */
    public StoreOrders() {

        ObservableList<Order> storeOrders = FXCollections.observableArrayList();
        orders = storeOrders ;
    }

    /**
     *
     * @return
     */
    public ObservableList<Order> getOrderList(){
        return this.orders;
    }


    /**
     *
     * @param obj
     *
     * @return
     */
    @Override
    public boolean add(Object obj){

        if(obj instanceof Order){
            Order order = (Order) obj;
            orders.add(order);
            return true;
        }
        return false;
    }

    /**
     *
     * @param obj
     *
     * @return
     */
    public boolean remove(Object obj){

        if(obj instanceof Order){
            Order order = (Order) obj;
            orders.remove(order);
            return true;
        }
        return false;
    }

    /**
     * Exports all Order Objects within the StoreOrder's ObservableList to a textfile
     *
     * @param file File to be written to
     *
     * @return True if file successfully written to, false otherwise
     */
    public boolean export(File file) {
        try {
            FileWriter output = new FileWriter(file);
            for (Order order : orders){
                output.write("Order: "+order.toString() + " Total: $"+String.format("%.2f",order.orderPriceTax()));
                output.write("\n");
            }
            output.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
