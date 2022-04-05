package rucafe.cs213project4;

public class MenuItem {

    protected double price;
    protected int quantity;
    //super class of all menu items (donut and coffee)
    //(any class defined for a menu item must extend this class)

    public double itemPrice(){
        //all subclasses override this method for calculate price of a menu item

        return this.price;

    }

    public int itemQuantity(){

        return this.quantity;

    }


}
