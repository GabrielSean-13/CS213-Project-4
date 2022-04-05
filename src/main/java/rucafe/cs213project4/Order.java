package rucafe.cs213project4;

import java.util.ArrayList;

public class Order {

    public static final double TAX_MULTIPLIER = 1.06625;

    private int orderNumber;
    private ArrayList<MenuItem> order;

    public Order(int orderNumber){
        this.orderNumber = orderNumber;
        order = new ArrayList<>();
    }

    public void addOrder(MenuItem item){
        order.add(item);
    }

    public void removeOrder(MenuItem item){
        order.remove(item);
    }
    // how to add and remove with interface idk

    public double orderPrice(){
        double sum = 0;

        for(MenuItem item: order){
            sum += item.itemPrice() * TAX_MULTIPLIER ;
        }

        return sum;
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
