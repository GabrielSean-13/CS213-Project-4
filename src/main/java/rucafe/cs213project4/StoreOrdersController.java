package rucafe.cs213project4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class StoreOrdersController {
    //all instance variables in controllers should be private

    private ShopMainMenuController shopMainMenuController;
    private StoreOrders storeOrders;

    @FXML
    private ListView<String> allOrdersOutput;

    private void displayAllOrders(){

    }

    @FXML
    private void cancelOrder(ActionEvent event) {

        //if there's nothing in the arraylist
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("The list is empty or an Order is not selected");
        errorAlert.setContentText("Please make sure you've selected an order to cancel");
        errorAlert.showAndWait();

    }

    @FXML
    private void exportOrders() {

        //if the list is not empty

        try {
            FileChooser chooser = new FileChooser();

            chooser.setTitle("Select a text file or create one to export to");
            chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                    new FileChooser.ExtensionFilter("All Files", "*.*"));
            Stage stage = new Stage();
            File file = chooser.showSaveDialog(stage);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            if (storeOrders.export(file)) {
                //alert.setContentText("Exported successfully.");
            } else {
                //alert.setContentText("An error occurred when exporting the file.");
            }
            alert.show();
        } catch (Exception e) {

        }
    }

    }


