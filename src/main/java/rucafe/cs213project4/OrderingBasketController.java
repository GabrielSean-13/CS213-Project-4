package rucafe.cs213project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import rucafe.cs213project4.Order;

import java.util.Collections;

public class OrderingBasketController {

    private ShopMainMenuController shopMainMenuController;

    @FXML
    private Label subTotalOrderCost;

    @FXML
    private Label totalOrderCost;

    @FXML
    private ListView<MenuItem> totalOrderOutput;

    @FXML
    private Label totalOrderTax;

    public void createShopMainMenuController(ShopMainMenuController shopMainMenuController){
        this.shopMainMenuController = shopMainMenuController;
        updateOrders();
    }

    void initialize(){

        totalOrderOutput.setItems(shopMainMenuController.getStoreOrderObservableList());




    }

    public void updateOrders(){

        ObservableList<MenuItem> created = FXCollections.observableArrayList();
        created.setAll(shopMainMenuController.getStoreOrderObservableList());


        totalOrderOutput.setItems(created);

    }

    @FXML
    void placeOrder(ActionEvent event) {

        if (shopMainMenuController.getStoreOrderObservableList().isEmpty() == true){

            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("The Order list is empty");
            errorAlert.setContentText("The list of Orders must be populated before placing an Order");
            errorAlert.showAndWait();


        }else{

            //we add the whole order arraylist to the storeorders arraylist

        }

    }

    @FXML
    void removeItemFromOrder(ActionEvent event) {

        //if an item has been selected to be removed

        //else...aka if no itemselected or empty list

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("The list is empty or an Order is not selected");
        errorAlert.setContentText("Please make sure you've selected an order to cancel");
        errorAlert.showAndWait();


    }

}

