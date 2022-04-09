package rucafe.cs213project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

import static rucafe.cs213project4.Coffee.*;

public class ShopCoffeeController {

    private ShopMainMenuController shopMainMenuController;

     @FXML
    private ToggleGroup coffeeType;

    @FXML
    private Label totalCoffeeOrderCost;

    @FXML
    private ListView<MenuItem> totalCoffeeOrderOutput;

    @FXML
    private ToggleButton caramelAddin;

    @FXML
    private ToggleButton creamAddin;

    @FXML
    private ToggleButton syrupAddin;

    @FXML
    private ToggleButton whippedCreamAddin;

    public void createShopMainMenuController(ShopMainMenuController shopMainMenuController){
        this.shopMainMenuController = shopMainMenuController;
        totalCoffeeOrderOutput.setItems(shopMainMenuController.getCoffeeCustomerOrder().getOrder());
        updateOrders();
        totalCoffeeOrderCost.setText(  (String.format("%.2f",shopMainMenuController.getCoffeeCustomerOrder().orderPrice())));

    }

    public void updateOrders(){

        ObservableList<MenuItem> created = FXCollections.observableArrayList();
        if (shopMainMenuController.getCoffeeCustomerOrder().getOrder().size() > 0) {
            ObservableList<MenuItem> Orders = shopMainMenuController.getCoffeeCustomerOrder().getOrder();
            created.addAll(Orders);
        }
        totalCoffeeOrderOutput.setItems(created);

    }

    public ArrayList<String> addTopping(){
        ArrayList<String> newCoffeeAddins = new ArrayList<>();
        if (creamAddin.isSelected()){
            newCoffeeAddins.add(CREAM);
        }
        if (syrupAddin.isSelected()){
            newCoffeeAddins.add(SYRUP);
        }
        if (caramelAddin.isSelected()){
            newCoffeeAddins.add(CARAMEL);
        }
        if (whippedCreamAddin.isSelected()){
            newCoffeeAddins.add(WHIPPEDCREAM);
        }

        return newCoffeeAddins;
    }

    @FXML
    public void addCoffeeToOrder() {

        if (coffeeType.getSelectedToggle() != null ){

            boolean duplicateDonutFound = false;
            String selectedCoffeeSizeToString = coffeeType.getSelectedToggle().toString();
            String selectedCoffeeSize = selectedCoffeeSizeToString.substring(selectedCoffeeSizeToString.indexOf("'")+1,
                    selectedCoffeeSizeToString.lastIndexOf("'"));
            Coffee newCoffee = new Coffee(selectedCoffeeSize, addTopping());
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

            resetButtons();
            totalCoffeeOrderOutput.setItems(shopMainMenuController.getCoffeeCustomerOrder().getOrder());
            totalCoffeeOrderCost.setText(  (String.format("%.2f",shopMainMenuController.getCoffeeCustomerOrder().orderPrice())));

        }else{
            coffeeAlert();
        }
    }

    private void resetButtons(){
        coffeeType.getSelectedToggle().setSelected(false);
        creamAddin.setSelected(false);
        syrupAddin.setSelected(false);
        caramelAddin.setSelected(false);
        whippedCreamAddin.setSelected(false);
    }

    private void coffeeAlert(){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("Coffee Order is not valid");
        errorAlert.setContentText("Please make sure you've selected the Size & Addins for the Coffee");
        errorAlert.showAndWait();
    }

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

    @FXML
    void grandeCoffeeSelected() {

    }


    @FXML
    void shortCoffeeSelected() {

    }

    @FXML
    void tallCoffeeSelected() {

    }

    @FXML
    void ventiCoffeeSelected() {

    }



}
