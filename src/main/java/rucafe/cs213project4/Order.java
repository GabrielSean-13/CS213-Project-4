package rucafe.cs213project4;

import java.util.ArrayList;

public class Order implements Customizable{

    public static final double TAX_MULTIPLIER = 1.06625;

    private static int orderCount = 1;
    private final int orderNumber;
    private ArrayList<MenuItem> order;

    public Order(){
        this.orderNumber = orderCount;
        orderCount++;
        order = new ArrayList<MenuItem>();
    }

    public boolean add(Object obj){
        if(obj instanceof MenuItem){
            MenuItem item = (MenuItem) obj;
            order.add(item);
            return true;
        }
        return false;
    }

    public boolean remove(Object obj){
        if(obj instanceof MenuItem){
            MenuItem item = (MenuItem) obj;
            order.remove(item);
            return true;
        }
        return false;
    }
    // how to add and remove with interface idk

    public double orderPrice(){
        double sum = 0;

        for(MenuItem item: order){
            sum += item.itemPrice() ;
        }

        return sum;
    }

    public double orderPriceTax(){
        return (this.orderPrice() * TAX_MULTIPLIER) ;
    }

    public ArrayList<MenuItem> getOrder(){
        return order;
    }

    public int getOrderNumber(){
        return orderNumber;
    }

    public int getQuantity(){
        return order.size();
    }



    //has unique order number and keeps the list of menu items added by the user

    //must implement a customizable interface to provide the behavior of adding and removing menu items
}
