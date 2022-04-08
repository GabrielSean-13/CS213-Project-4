package rucafe.cs213project4;

public class MenuItem {


    protected int quantity;
    protected double price;
    //super class of all menu items (donut and coffee)
    //(any class defined for a menu item must extend this class)

    public double itemPrice(){
        //all subclasses override this method for calculate price of a menu item
        return this.price;
    }

    public int getQuantity(){
        //all subclasses override this method for calculate price of a menu item
        return this.quantity;
    }


    public boolean compare(MenuItem menuItem){
        if(menuItem instanceof Donut && this instanceof Donut){
            return true;
        }else if(menuItem instanceof Coffee && this instanceof Coffee){
            return true;
        }
        return false;
    }

}
