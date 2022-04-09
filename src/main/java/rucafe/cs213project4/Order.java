package rucafe.cs213project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Class that represents an Order Object
 *
 * Methods within this class can construct an Order Object,
 * add and remove an Object from the Order Object's ObservableList,
 * calculate the price of an Order with or without tax,
 * get the Order Object's order number, get the Order Object's quantity,
 * get the Order Object's ObservableList, set the Order OBject's order number,
 * and represent an Order Object as a String
 *
 * @author Mark Holleran, Abhitej Bokka
 */
public class Order implements Customizable{

    public static final double TAX_MULTIPLIER = 1.06625;

    private int orderNumber;
    private ObservableList<MenuItem> orderForListView;

    Order(){

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

    public void setOrderNumber(int uniqueOrderNumber){

        this.orderNumber = uniqueOrderNumber;


    }

}
