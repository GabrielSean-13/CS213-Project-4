package rucafe.cs213project4;

import java.util.ArrayList;

/**
 * Class that represents a Coffee MenuItem Object
 * <p>
 * Methods within this class can create a Coffee Object, add or remove addins, calculate Coffee price,
 * construct a Coffee Object, get Coffee size, get Coffee addins, compare between two Coffee Objects, and
 * return a string representation of a Coffee Object
 *
 * @author Mark Holleran, Abhitej Bokka
 */
public class Coffee extends MenuItem implements Customizable {

    public static final double PRICE_OF_SIZE_SHORT = 1.69;
    public static final double PRICE_OF_SIZE_TALL = 2.09;
    public static final double PRICE_OF_SIZE_GRANDE = 2.49;
    public static final double PRICE_OF_SIZE_VENTI = 2.89;
    public static final double PRICE_OF_SINGLE_ADDIN = .30;

    public static final String SHORT = "Short";
    public static final String TALL = "Tall";
    public static final String GRANDE = "Grande";
    public static final String VENTI = "Venti";

    public static final String CREAM = "Cream";
    public static final String SYRUP = "Syrup";
    public static final String CARAMEL = "Caramel";
    public static final String WHIPPEDCREAM = "Whipped Cream";

    protected ArrayList<String> addins;

    public String size = null;


    /**
     * Constructs a Coffee Object given a Size and Arraylist of Addins as parameters
     *
     * @param size   String representing the Size of the Coffee Object
     * @param addins Arraylist of String Objects containing the Addins of the Coffee Object
     */
    public Coffee(String size, ArrayList<String> addins) {
        this.size = size;
        this.addins = addins;
        this.price = itemPrice();
    }

    /**
     * Calculates the price of a Coffee Object based on
     * it's size and number of addins.
     *
     * @return Double representing the cost of the Coffee Object
     */
    @Override
    public double itemPrice() {
        if (size.equals(SHORT)) {
            price = PRICE_OF_SIZE_SHORT;
        } else if (size.equals(TALL)) {
            price = PRICE_OF_SIZE_TALL;
        } else if (size.equals(GRANDE)) {
            price = PRICE_OF_SIZE_GRANDE;
        } else if (size.equals(VENTI)) {
            price = PRICE_OF_SIZE_VENTI;
        }
        return this.price + (addins.size() * PRICE_OF_SINGLE_ADDIN);
    }

    /**
     * Returns the target Coffee Object's Size parameter
     *
     * @return String representing the Coffee Object's Size parameter
     */
    public String getCoffeeSize() {
        return this.size;
    }

    /**
     * Returns the target Coffee Object's ArrayList of Addins
     *
     * @return ArrayList of Strings containing all of the Addins that the Coffee Object has
     */
    public ArrayList<String> getCoffeeAddins() {
        return this.addins;
    }

    /**
     * Adds an Addin to the target Coffee Object's ArrayList of Addins
     *
     * @param obj String containing the Addin to be added
     * @return True if successfully added, false otherwise
     */
    public boolean add(Object obj) {
        if (obj instanceof String) {
            String topping = (String) obj;
            addins.add(topping);
            return true;
        }
        return false;
    }

    /**
     * Removes an Addin from the target Coffee Object's Arraylist of Addins
     *
     * @param obj String containing he Addin to be removed
     * @return True if successfully removed, false otherwise
     */
    public boolean remove(Object obj) {
        if (obj instanceof String) {
            String topping = (String) obj;
            addins.remove(topping);
            return true;
        }
        return false;
    }

    /**
     * Compares two Coffee Objects for equality
     *
     * @param menuItem Coffee Object to be compared with the target Coffee Object
     * @return True if both objects are the same size and contain the same Addins, false otherwise
     */
    public boolean compare(MenuItem menuItem) {
        if (menuItem instanceof Coffee) {
            if (this.getCoffeeAddins().equals(((Coffee) menuItem).getCoffeeAddins())
                    && this.getCoffeeSize().equals(((Coffee) menuItem).getCoffeeSize())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a String representation of a Coffee object
     *
     * @return String representation of a Coffee Object containing its quantity, size, and Addins
     */
    @Override
    public String toString() {

        StringBuilder coffeeToString = new StringBuilder(this.getQuantity() + " " + this.getCoffeeSize() + " Coffee");
        if (this.getQuantity() > 1) {
            coffeeToString.append("s");
        }

        if (getCoffeeAddins().size() > 0) {
            coffeeToString.append(" with:");
            for (String s : getCoffeeAddins()) {
                coffeeToString.append(" ").append(s);
            }
        }

        return coffeeToString.toString();
    }
}