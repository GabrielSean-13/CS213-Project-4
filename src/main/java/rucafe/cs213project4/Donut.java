package rucafe.cs213project4;

import java.util.ArrayList;

public class Donut extends MenuItem {

    protected String flavor;
    protected String type;
    protected ArrayList<String> addins;

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
        //or just itemPrice() idk which
    }

    @Override
    public double itemPrice(){
        if(type.equals(YEAST)){
            price = YEAST_PRICE;
        }else if(type.equals(CAKE)){
            price = CAKE_PRICE;
        }else{
            price = HOLE_PRICE;
        }

        return this.price;
    }

    public String getDonutType (){

        return this.type;

    }

    public ArrayList<String> getDonutAddins(){

        return this.addins;
    }

}