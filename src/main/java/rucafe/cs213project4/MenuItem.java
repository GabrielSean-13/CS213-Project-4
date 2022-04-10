package rucafe.cs213project4;

/**
 * Class representing a MenuItem Object which is extended by Coffee and Donut Objects
 *
 * Methods within this class can get a MenuItem's price, get a MenuItem's quantity,
 * and compare two MenuItem Objects for equality
 *
 * @author Mark Holleran, Abhitej Bokka
 */
public class MenuItem {

    protected int quantity;
    protected double price;

    /**
     * Returns the price of a MenuItem Object
     *
     * @return Double representing the target MenuItem Object's Price parameter
     */
    public double itemPrice() {
        return this.price;
    }

    /**
     * Returns the quantity of a MenuItem Object
     *
     * @return Double representing the target MenuItem Object's Quantity parameter
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Compares two MenuItem Objects for equality
     *
     * @param menuItem MenuItem to compare with the target MenuItem Object
     *
     * @return True if both MenuItem Objects are of the same instance, false otherwise
     */
    public boolean compare(MenuItem menuItem) {
        if (menuItem instanceof Donut && this instanceof Donut) {
            return true;
        } else return menuItem instanceof Coffee && this instanceof Coffee;
    }
}
