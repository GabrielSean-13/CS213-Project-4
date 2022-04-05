package rucafe.cs213project4;

import java.util.ArrayList;

public class Coffee extends MenuItem {

    public static final double PRICE_OF_SIZE_SHORT = 1.69;
    public static final double PRICE_OF_SIZE_TALL = 2.09;
    public static final double PRICE_OF_SIZE_GRANDE = 2.49;
    public static final double PRICE_OF_SIZE_VENTI = 2.89;
    public static final double PRICE_OF_SINGLE_ADDIN = .30;

    public static final String SHORT = "SHORT";
    public static final String TALL = "TALL";
    public static final String GRANDE = "GRANDE";
    public static final String VENTI = "VENTI";

    protected ArrayList<String> addins;
    public String size = null;

    @Override
    public double itemPrice(){

        if (size.equals(SHORT)){
            price = PRICE_OF_SIZE_SHORT;
        }else if (size.equals(TALL)){
            price = PRICE_OF_SIZE_TALL;
        }else if (size.equals(GRANDE)){
            price = PRICE_OF_SIZE_GRANDE;
        }else{
            price = PRICE_OF_SIZE_VENTI;
        }

        return this.price + (addins.size() * PRICE_OF_SINGLE_ADDIN);

    }

    public Coffee(String size, ArrayList<String> addins){

        this.size = size;
        this.addins = addins;
        this.price = itemPrice();

    }

    public String getCoffeeSize(){

        return this.size;
    }

    public ArrayList<String> getCoffeeAddins(){

        return this.addins;
    }

}


//This allows the user to add the coffee to the ordering basket. The GUI shall provide the
//options of the sizes: Short, Tall, Grande and Venti, and the options of the add-ins: cream, syrup, milk, caramel,
//and whipped cream. While adding or removing the add-ins or changing the sizes, the GUI shall display the
//running sub-total of the coffee, with 2 decimal places.

//The price for a Short black coffee is $1.69. Each
//add-in costs $0.30. The price increase for the next size is $0.40. For example, the price increase for a Grande is
//$0.80, therefore a Grande black coffee is $2.49, and a Grande coffee with cream and syrup would be $3.09.