package rucafe.cs213project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class StoreOrdersController {

    private ShopMainMenuController shopMainMenuController;
    private StoreOrders storeOrders;

    @FXML
    private ListView<String> allOrdersOutput;

    public void initialize() {

    }

    public void update() {


        ObservableList<String> lvElem = FXCollections.observableArrayList();

        for (Order order : shopMainMenuController.getStoreOrders().getOrderList()) {

            lvElem.add(order.toString() + " " + "Total: $" + String.format("%.2f", order.orderPriceTax()));
        }

        allOrdersOutput.setItems(lvElem);
    }

    public void createShopMainMenuController(ShopMainMenuController shopMainMenuController) {
        this.shopMainMenuController = shopMainMenuController;
        update();
    }


    @FXML
    private void cancelOrder() {

        if (allOrdersOutput.getSelectionModel().getSelectedItem() != null) {

            shopMainMenuController.getStoreOrders().getOrderList().remove((allOrdersOutput.getSelectionModel().getSelectedIndex()));
            update();

        } else {

            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("The list is empty or an Order is not selected");
            errorAlert.setContentText("Please make sure you've selected an order to cancel");
            errorAlert.showAndWait();

        }

    }

    @FXML
    private void exportOrders() {

        if (!shopMainMenuController.getStoreOrderObservableList().isEmpty()) {

            try {
                FileChooser chooser = new FileChooser();

                chooser.setTitle("Select a text file or create one to export to");
                chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                        new FileChooser.ExtensionFilter("All Files", "*.*"));
                Stage stage = new Stage();
                File file = chooser.showSaveDialog(stage);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                if (shopMainMenuController.getStoreOrders().export(file)) {
                    alert.setHeaderText("Exported successfully.");
                    alert.setContentText("The text file now contains all store Orders");
                } else {
                    alert.setContentText("Error occurred when exporting Orders.");
                }
                alert.show();
            } catch (Exception e) {

            }
        } else {
            createAlert();
        }

    }

    private void createAlert(){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);

        errorAlert.setHeaderText("There are no Orders to export");
        errorAlert.setContentText("place an Order before trying to export.");

        errorAlert.showAndWait();
    }

}


