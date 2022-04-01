package rucafe.cs213project4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class ShopCoffeeController {

    @FXML
    private ToggleGroup coffeeToppingType;

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
    private ListView<?> totalCoffeeOrderOutput;

    @FXML
    private ToggleButton ventiCoffee;

    @FXML
    void addCoffeeToOrder(ActionEvent event) {

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
