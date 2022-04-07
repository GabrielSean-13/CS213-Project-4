package rucafe.cs213project4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

import static rucafe.cs213project4.Coffee.*;
import static rucafe.cs213project4.Donut.*;
import rucafe.cs213project4.Order;

public class ShopCoffeeController {

    private Order order;
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
    private ToggleButton creamAddin;

    @FXML
    private ToggleButton syrupAddin;

    @FXML
    private ToggleButton whippedCreamAddin;

    @FXML
    void addCoffeeToOrder(ActionEvent event) {

        if (coffeeType.getSelectedToggle() != null && (creamAddin.isSelected() == true || syrupAddin.isSelected() == true || caramelAddin.isSelected() == true || whippedCreamAddin.isSelected() == true)){

            String selectedCoffeeSizeToString = coffeeType.getSelectedToggle().toString();

            ArrayList<String> newCoffeeAddins = new ArrayList<>();

            if (creamAddin.isSelected() == true){

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

            order.getOrder().add(newCoffee);

            coffeeType.getSelectedToggle().setSelected(false);
            creamAddin.setSelected(false);
            syrupAddin.setSelected(false);
            caramelAddin.setSelected(false);
            whippedCreamAddin.setSelected(false);

            System.out.println(order.getOrder().toString());



        }else{

            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Coffee Order is not valid");
            errorAlert.setContentText("Please make sure you've selected the Size & Addins for the Coffee");
            errorAlert.showAndWait();

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
