package rucafe.cs213project4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class OrderingBasketController {

    @FXML
    private Label subTotalOrderCost;

    @FXML
    private Label totalOrderCost;

    @FXML
    private ListView<Order> totalOrderOutput;

    @FXML
    private Label totalOrderTax;

    @FXML
    void placeOrder(ActionEvent event) {

    }

    @FXML
    void removeItemFromOrder(ActionEvent event) {

    }

}

