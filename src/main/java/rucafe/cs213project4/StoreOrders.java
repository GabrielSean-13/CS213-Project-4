package rucafe.cs213project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StoreOrders implements Customizable{

    private ObservableList<Order> orders;

    public ObservableList<Order> getOrderList(){
        return this.orders;
    }

    public void setOrderObservableList(ObservableList<Order> orders){
        this.orders = orders;
    }

    public StoreOrders() {

        ObservableList<Order> storeOrders = FXCollections.observableArrayList();
        orders = storeOrders ;
    }


@Override
    public boolean add(Object obj){

        if(obj instanceof Order){
            Order order = (Order) obj;
            orders.add(order);
            return true;
        }
        return false;
    }

    public boolean remove(Object obj){

        if(obj instanceof Order){
            Order order = (Order) obj;
            orders.remove(order);
            return true;
        }
        return false;
    }

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
