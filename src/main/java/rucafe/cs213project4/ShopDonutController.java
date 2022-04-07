package rucafe.cs213project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;


public class ShopDonutController {

    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;
    public static final int SEVEN = 7;
    public static final int EIGHT = 8;
    public static final int NINE = 9;
    public static final int TEN = 10;
    public static final int ELEVEN = 11;
    public static final int TWELVE = 12;

    private ShopMainMenuController shopMainMenuControllersDonut;

    //private Order order;

    @FXML
    private ToggleButton cakeDonut;

    @FXML
    private ToggleGroup donutFlavor;

    @FXML
    private ToggleButton donutHoles;

    @FXML
    private ToggleGroup donutType;

    @FXML
    private ToggleButton flavorChoiceOne;

    @FXML
    private ToggleButton flavorChoiceTwo;

    @FXML
    private ToggleButton flavorChoiceThree;

    @FXML
    private ToggleButton flavorChoiceFour;

    @FXML
    private ChoiceBox<Integer> quantityOfOrder;

    @FXML
    private ListView<MenuItem> donutListView;

    @FXML
    private Label totalOrderCost;

    @FXML
    private ToggleButton yeastDonut;

    public void createShopMainMenuController(ShopMainMenuController shopMainMenuController){
        this.shopMainMenuControllersDonut = shopMainMenuController;
        updateOrders();
    }

    public void updateOrders(){

        ObservableList<MenuItem> created = FXCollections.observableArrayList();
        if (shopMainMenuControllersDonut.getDonutCustomerOrder().getOrder().isEmpty() == false) {
            ObservableList<MenuItem> Orders = shopMainMenuControllersDonut.getDonutCustomerOrder().getOrder();
            created.addAll(Orders);
        }
        donutListView.setItems(created);

    }

    @FXML
    public void initialize(){


        //order = new Order();
        quantityOfOrder.getItems().addAll(ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,ELEVEN,TWELVE);

        quantityOfOrder.setValue(ONE);
       // yeastDonut.setSelected(true);

        flavorChoiceOne.setText("Chocolate");
        flavorChoiceTwo.setText("Strawberry");
        flavorChoiceThree.setText("Cinnamon");
        flavorChoiceFour.setText("Coconut");

        //System.out.println(shopMainMenuControllersDonut);
        //donutListView.setItems(shopMainMenuController.getDonutCustomerOrder().getOrder());





    }



    @FXML
    void addToOrder(ActionEvent event) {

        if (donutType.getSelectedToggle() != null && donutFlavor.getSelectedToggle() != null){

            //if here everything is filled out
            //god level java workaround

            String selectedDonutTypeButtonToString = donutType.getSelectedToggle().toString();

            String selectedDonutFlavorButtonToString = donutFlavor.getSelectedToggle().toString();

            String selectedDonutType = selectedDonutTypeButtonToString.substring(selectedDonutTypeButtonToString.indexOf("'")+1, selectedDonutTypeButtonToString.lastIndexOf("'"));

            String selectedDonutFlavor = selectedDonutFlavorButtonToString.substring(selectedDonutFlavorButtonToString.indexOf("'")+1, selectedDonutFlavorButtonToString.lastIndexOf("'"));

            Donut newDonutOrder = new Donut(selectedDonutType, selectedDonutFlavor);

            newDonutOrder.quantity = quantityOfOrder.getSelectionModel().getSelectedIndex()+1;

            donutType.getSelectedToggle().setSelected(false);
            donutFlavor.getSelectedToggle().setSelected(false);

           //we need to compare the name and type and see if they match
            //if one matches we take its quantity and add it it the new one and put it into list

            shopMainMenuControllersDonut.getDonutCustomerOrder().add(newDonutOrder);

            System.out.println(shopMainMenuControllersDonut.getDonutCustomerOrder().getOrder().toString());
            updateOrders();
            //donutListView.setItems(shopMainMenuControllersDonut.getDonutCustomerOrder().getOrder());



        }else {
            //make pop up that says to populate
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Donut Order is not valid");
            errorAlert.setContentText("Please make sure you've selected the Type & Flavor for the Donut(s)");
            errorAlert.showAndWait();

        }

    }

    @FXML
    void removeFromOrder() {

        if (donutListView.getSelectionModel().getSelectedItem() != null){
            shopMainMenuControllersDonut.getDonutCustomerOrder().remove(donutListView.getSelectionModel().getSelectedItem());
            updateOrders();
        }else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Item cancel is not valid");
            errorAlert.setContentText("Please make sure you've selected an item to cancel");
            errorAlert.showAndWait();
        }

    }

    @FXML
    void DonutHolesSelected() {

        flavorChoiceOne.setText("Double Chocolate");
        flavorChoiceTwo.setText("Jelly Filled");
        flavorChoiceThree.setText("Oreo");
        flavorChoiceFour.setText("French");

    }

    @FXML
    void cakeDonutSelected() {

        flavorChoiceOne.setText("Red Velvet");
        flavorChoiceTwo.setText("Powder Sugar");
        flavorChoiceThree.setText("Baked Jelly");
        flavorChoiceFour.setText("Boston Cream");

    }



    @FXML
    void yeastDonutSelected() {

        flavorChoiceOne.setText("Chocolate");
        flavorChoiceTwo.setText("Strawberry");
        flavorChoiceThree.setText("Cinnamon");
        flavorChoiceFour.setText("Coconut");

    }

}
