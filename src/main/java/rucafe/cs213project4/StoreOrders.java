package rucafe.cs213project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StoreOrders implements Customizable{

    private ObservableList<Order> orders;
    //private static int orderNumber = 1;


    public ObservableList<Order> getOrderArrayList(){
        return this.orders;
    }

    public void setOrderArrayList(ObservableList<Order> orders){
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
            for (Order order : orders)
                output.write(order.toString() + "\n");
            output.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }




    //keeps a list of orders placed by the user
    //probably hashtable?

    //must implement the customizable interface to provide the behavior for adding and removing orders

    //also have to export all store orders placed to a text file
    //file must include: list of store orders each one including all the details of the order
}
