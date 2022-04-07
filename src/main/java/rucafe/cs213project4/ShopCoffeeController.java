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
    private ToggleButton grandeCoffee;

    @FXML
    private ToggleButton shortCoffee;

    @FXML
    private ToggleButton tallCoffee;

    @FXML
    private Label totalCoffeeOrderCost;

    @FXML
    private ListView<MenuItem> totalCoffeeOrderOutput;

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






    public void createShopMainMenuController(ShopMainMenuController shopMainMenuController){
        this.shopMainMenuController = shopMainMenuController;
        updateOrders();
    }

    public void updateOrders(){

        ObservableList<MenuItem> created = FXCollections.observableArrayList();
        if (shopMainMenuController.getCoffeeCustomerOrder().getOrder().size() > 0) {
            ObservableList<MenuItem> Orders = shopMainMenuController.getCoffeeCustomerOrder().getOrder();
            created.addAll(Orders);
        }
        totalCoffeeOrderOutput.setItems(created);

    }


    void initialize() {

        totalCoffeeOrderOutput.setItems(shopMainMenuController.getCoffeeCustomerOrder().getOrder());


    }





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
            newCoffee.quantity = 1;

            shopMainMenuController.getCoffeeCustomerOrder().add(newCoffee);

            System.out.println(shopMainMenuController.getCoffeeCustomerOrder().getOrder().toString());




            coffeeType.getSelectedToggle().setSelected(false);
            creamAddin.setSelected(false);
            syrupAddin.setSelected(false);
            caramelAddin.setSelected(false);
            whippedCreamAddin.setSelected(false);

            totalCoffeeOrderOutput.setItems(shopMainMenuController.getCoffeeCustomerOrder().getOrder());




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
