package rucafe.cs213project4;

public class Donut extends MenuItem {

    protected String flavor;
    protected String type;

    public static final String YEAST = "Yeast Donut";
    public static final String CAKE = "Cake Donut";
    public static final String HOLE = "Donut Hole";

    public static final double YEAST_PRICE = 1.59;
    public static final double CAKE_PRICE = 1.79;
    public static final double HOLE_PRICE = 0.39;


    public Donut(String donutType, String donutFlavor){
        type = donutType;
        flavor = donutFlavor;

        this.itemPrice();
    }

    @Override
    public double itemPrice(){
        if(type.equals(YEAST)){
            price = YEAST_PRICE;
        }else if(type.equals(CAKE)){
            price = CAKE_PRICE;
        }else if(type.equals(HOLE)){
            price = HOLE_PRICE;
        }

        return this.price;
    }

    public String getDonutType (){
        return this.type;
    }

    public String getFlavor (){
        return this.flavor;
    }

    @Override
    public String toString(){

        String str = this.getQuantity() + " " + this.getFlavor() + " " + this.getDonutType();
        if(this.getQuantity() > 1){
            str += "s";
        }
                // 1 Glazed Yeast Donut
        return str;
    }

    public boolean compare(MenuItem menuItem){
        if(menuItem instanceof Donut){
            if(this.getFlavor().equals(((Donut) menuItem).getFlavor())
                    && this.getDonutType().equals(((Donut) menuItem).getDonutType())){
                return true;
            }
        }
        return false;
    }
}