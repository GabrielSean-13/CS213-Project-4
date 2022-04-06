package rucafe.cs213project4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;

import static rucafe.cs213project4.Coffee.*;

public class ShopCoffeeController {
    //all instance variables in controllers should be private
       @FXML
    private ToggleGroup coffeeType;

    @FXML
    private ToggleButton grandeCoffee;

    @FXML
    private ToggleButton shortCoffee;

    @FXML
    private ToggleButton tallCoffee;

    @FXML
    private Label totalCoffeeOrderCost;

    @FXML
    private ListView<Coffee> totalCoffeeOrderOutput;

    @FXML
    private ToggleButton ventiCoffee;

    @FXML
    private ToggleButton caramelAddin;

    @FXML
    private ToggleButton creamAddiin;

    @FXML
    private ToggleButton syrupAddin;

    @FXML
    private ToggleButton whippedCreamAddin;

    @FXML
    void addCoffeeToOrder(ActionEvent event) {


        if (coffeeType.getSelectedToggle() != null){

            String selectedCoffeeSizeToString = coffeeType.getSelectedToggle().toString();

            ArrayList<String> newCoffeeAddins = new ArrayList<>();

            if (creamAddiin.isSelected() == true){

                newCoffeeAddins.add(CREAM);
                //for these we really want to access the public variable form the coffee class

            }
            if (syrupAddin.isSelected() == true){

                newCoffeeAddins.add(SYRUP);

            }
            if (caramelAddin.isSelected() == true){

                newCoffeeAddins.add(CREAM);

            }
            if (whippedCreamAddin.isSelected() == true){

                newCoffeeAddins.add(WHIPPEDCREAM);

            }

            String selectedCoffeeSize = selectedCoffeeSizeToString.substring(selectedCoffeeSizeToString.indexOf("'")+1, selectedCoffeeSizeToString.lastIndexOf("'"));

            Coffee newCoffee = new Coffee(selectedCoffeeSize, newCoffeeAddins);

            



                    //then we want to desleect the buttons so that it's a brand new slate



        }else{
            //we want to have a pop up here that says wahtever
            //then when we click okay it goes okay

        }





    }

    @FXML
    void grandeCoffeeSelected(ActionEvent event) {

    }

    @FXML
    void removeCoffeeFromOrder(ActionEvent event) {

    }

    @FXML
    void shortCoffeeSelected(ActionEvent event) {

    }

    @FXML
    void tallCoffeeSelected(ActionEvent event) {

    }

    @FXML
    void ventiCoffeeSelected(ActionEvent event) {

    }

}
