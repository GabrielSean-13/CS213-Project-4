package rucafe.cs213project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Order implements Customizable{

    public static final double TAX_MULTIPLIER = 1.06625;

    private static int orderCount = 1;
    private final int orderNumber;
    private ObservableList<MenuItem> orderForListView;

    //private ArrayList<MenuItem> order;
    Order(){
        this.orderNumber = orderCount;
        orderCount++;
        //order = new ArrayList<MenuItem>();

        ObservableList<MenuItem> observableList = FXCollections.observableArrayList();

        orderForListView = observableList;

    }

    public boolean add(Object obj){
        if(obj instanceof MenuItem){
            MenuItem item = (MenuItem) obj;
            //order.add(item);
            orderForListView.add(item);
            return true;
        }
        return false;
    }

    public boolean remove(Object obj){
        if(obj instanceof MenuItem){
            MenuItem item = (MenuItem) obj;
            //order.remove(item);
            orderForListView.remove(item);

            return true;
        }
        return false;
    }
    // how to add and remove with interface idk

    public double orderPrice(){
        double sum = 0;

        for(MenuItem item: orderForListView){
            sum += item.itemPrice() * item.getQuantity() ;
        }

        return sum;
    }

    public String toString(){

        return orderNumber + " " + orderForListView.toString();


    }

    public double orderPriceTax(){
        return (this.orderPrice() * TAX_MULTIPLIER) ;
    }

    public ObservableList<MenuItem> getOrder(){
        return orderForListView;
    }

    public int getOrderNumber(){
        return orderNumber;
    }

    public int getQuantity(){
        return orderForListView.size();
    }



    //has unique order number and keeps the list of menu items added by the user

    //must implement a customizable interface to provide the behavior of adding and removing menu items
}
