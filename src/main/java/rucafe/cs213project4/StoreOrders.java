package rucafe.cs213project4;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StoreOrders implements Customizable{

    private ArrayList<Order> orders;
    //private static int orderNumber = 1;

    public StoreOrders() {
        orders = new ArrayList<>();
    }


    public ArrayList<Order> getOrders(){
        return orders;
    }


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




    //keeps a list of orders placed by the user
    //probably hashtable?

    //must implement the customizable interface to provide the behavior for adding and removing orders

    //also have to export all store orders placed to a text file
    //file must include: list of store orders each one including all the details of the order
}
