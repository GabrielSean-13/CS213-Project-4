package rucafe.cs213project4;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StoreOrders {

    private ArrayList<Order> orders;

    public StoreOrders() {
        orders = new ArrayList<>();
    }


    public ArrayList<Order> getOrders(){
        return orders;
    }


    public void addOrder(Order order){
        orders.add(order);
    }

    public void removeOrder(Order order){
        orders.remove(order);
    }




    //keeps a list of orders placed by the user
    //probably hashtable?

    //must implement the customizable interface to provide the behavior for adding and removing orders

    //also have to export all store orders placed to a text file
    //file must include: list of store orders each one including all the details of the order
}
