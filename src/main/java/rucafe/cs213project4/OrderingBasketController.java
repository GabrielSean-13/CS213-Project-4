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

        totalOrderOutput.setItems(shopMainMenuController.getOrderObservableList());




    }

    public void updateOrders(){

        ObservableList<MenuItem> created = FXCollections.observableArrayList();
        created.setAll(shopMainMenuController.getOrderObservableList());


        totalOrderOutput.setItems(created);

    }

    @FXML
    void placeOrder(ActionEvent event) {

        if (shopMainMenuController.getOrderObservableList().isEmpty()){

            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("The Order list is empty");
            errorAlert.setContentText("The list of Orders must be populated before placing an Order");
            errorAlert.showAndWait();


        }else{
            //Order order = new Order();

            shopMainMenuController.getStoreOrderObservableList().add(shopMainMenuController.getTotalCustomerOrder());
            //we add the whole order arraylist to the storeorders arraylist

        }

    }


    @FXML
    void removeItemFromOrder() {

        if (totalOrderOutput.getSelectionModel().getSelectedItem() != null && (totalOrderOutput.getSelectionModel().getSelectedItem() instanceof Donut)){
            shopMainMenuController.getDonutCustomerOrder().remove(totalOrderOutput.getSelectionModel().getSelectedItem());
            updateOrders();
        }else if(totalOrderOutput.getSelectionModel().getSelectedItem() != null && (totalOrderOutput.getSelectionModel().getSelectedItem() instanceof Coffee)){
            shopMainMenuController.getCoffeeCustomerOrder().remove(totalOrderOutput.getSelectionModel().getSelectedItem());
            updateOrders();
        }else{
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Item cancel is not valid");
            errorAlert.setContentText("Please make sure you've selected an item to cancel");
            errorAlert.showAndWait();
        }
    }

}

