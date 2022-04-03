package rucafe.cs213project4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class ShopDonutController {
    //all instance variables in controllers should be private
    @FXML
    private ToggleButton cakeDonut;

    @FXML
    private ToggleButton donutHoles;

    @FXML
    private ToggleGroup donutType;

    @FXML
    private TextField quantityOfOrder;

    @FXML
    private Label totalOrderCost;

    @FXML
    private ToggleButton yeastDonut;

    @FXML
    void DonutHolesSelected(ActionEvent event) {

    }

    @FXML
    void addToOrder(ActionEvent event) {

    }

    @FXML
    void cakeDonutSelected(ActionEvent event) {

    }

    @FXML
    void removeFromOrder(ActionEvent event) {

    }

    @FXML
    void yeastDonutSelected(ActionEvent event) {

    }

}
