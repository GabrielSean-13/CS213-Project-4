package rucafe.cs213project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.ArrayList;
import static rucafe.cs213project4.Coffee.*;

/**
 *
 */
public class ShopCoffeeController {


     @FXML
    private ToggleGroup coffeeType;

    @FXML
    private ToggleButton grandeCoffee;

    @FXML
    private ToggleButton shortCoffee;

    @FXML
    private ToggleButton tallCoffee;

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
    private Label totalCoffeeOrderCost;

    @FXML
    private ListView<MenuItem> totalCoffeeOrderOutput;

    private ShopMainMenuController shopMainMenuController;


    /**
     *
     * @param shopMainMenuController
     */
    public void createShopMainMenuController(ShopMainMenuController shopMainMenuController){
        this.shopMainMenuController = shopMainMenuController;
        totalCoffeeOrderOutput.setItems(shopMainMenuController.getCoffeeCustomerOrder().getOrder());
        updateOrders();
        totalCoffeeOrderCost.setText(  (String.format("%.2f",shopMainMenuController.getCoffeeCustomerOrder().orderPrice())));

    }

    /**
     *
     */
    public void updateOrders(){

        ObservableList<MenuItem> created = FXCollections.observableArrayList();
        if (shopMainMenuController.getCoffeeCustomerOrder().getOrder().size() > 0) {
            ObservableList<MenuItem> Orders = shopMainMenuController.getCoffeeCustomerOrder().getOrder();
            created.addAll(Orders);
        }
        totalCoffeeOrderOutput.setItems(created);

    }


    /**
     *
     * @param event
     */
    @FXML
    void addCoffeeToOrder(ActionEvent event) {

        if (coffeeType.getSelectedToggle() != null ){

            boolean duplicateDonutFound = false;

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
                newCoffeeAddins.add(CARAMEL);
            }
            if (whippedCreamAddin.isSelected() == true){
                newCoffeeAddins.add(WHIPPEDCREAM);
            }
            String selectedCoffeeSize = selectedCoffeeSizeToString.substring(selectedCoffeeSizeToString.indexOf("'")+1, selectedCoffeeSizeToString.lastIndexOf("'"));
            Coffee newCoffee = new Coffee(selectedCoffeeSize, newCoffeeAddins);
            newCoffee.quantity = 1;

            for (MenuItem num : shopMainMenuController.getCoffeeCustomerOrder().getOrder()) {
                if (num.compare(newCoffee) == true){
                    duplicateDonutFound = true;
                    num.quantity += newCoffee.quantity;
                    updateOrders();
                }
            }
            if (duplicateDonutFound == false){
                shopMainMenuController.getCoffeeCustomerOrder().add(newCoffee);
                updateOrders();
            }
            coffeeType.getSelectedToggle().setSelected(false);
            creamAddin.setSelected(false);
            syrupAddin.setSelected(false);
            caramelAddin.setSelected(false);
            whippedCreamAddin.setSelected(false);
            totalCoffeeOrderOutput.setItems(shopMainMenuController.getCoffeeCustomerOrder().getOrder());
            totalCoffeeOrderCost.setText(  (String.format("%.2f",shopMainMenuController.getCoffeeCustomerOrder().orderPrice())));
        }else{
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Coffee Order is not valid");
            errorAlert.setContentText("Please make sure you've selected the Size & Addins for the Coffee");
            errorAlert.showAndWait();
        }
    }

    /**
     *
     */
    @FXML
    void removeCoffeeFromOrder() {
        if (totalCoffeeOrderOutput.getSelectionModel().getSelectedItem() != null){
            shopMainMenuController.getCoffeeCustomerOrder().remove(totalCoffeeOrderOutput.getSelectionModel().getSelectedItem());
            updateOrders();
            totalCoffeeOrderCost.setText(  (String.format("%.2f",shopMainMenuController.getCoffeeCustomerOrder().orderPrice())));
        }else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Item cancel is not valid");
            errorAlert.setContentText("Please make sure you've selected an item to cancel");
            errorAlert.showAndWait();
        }
    }
}
