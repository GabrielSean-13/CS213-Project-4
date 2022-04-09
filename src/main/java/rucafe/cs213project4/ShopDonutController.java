package rucafe.cs213project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;


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

    public void createShopMainMenuController(ShopMainMenuController shopMainMenuController) {
        this.shopMainMenuControllersDonut = shopMainMenuController;
        updateOrders();
        totalOrderCost.setText((String.format("%.2f", shopMainMenuController.getDonutCustomerOrder().orderPrice())));

    }

    public void updateOrders() {

        ObservableList<MenuItem> created = FXCollections.observableArrayList();
        if (shopMainMenuControllersDonut.getDonutCustomerOrder().getOrder().size() > 0) {
            ObservableList<MenuItem> Orders = shopMainMenuControllersDonut.getDonutCustomerOrder().getOrder();
            created.addAll(Orders);
        }
        donutListView.setItems(created);

    }

    @FXML
    public void initialize() {

        quantityOfOrder.getItems().addAll(ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELVE);

        quantityOfOrder.setValue(ONE);

        flavorChoiceOne.setText("Chocolate");
        flavorChoiceTwo.setText("Strawberry");
        flavorChoiceThree.setText("Cinnamon");
        flavorChoiceFour.setText("Coconut");


    }

    private Donut createDonut() {
        String selectedDonutTypeButtonToString = donutType.getSelectedToggle().toString();
        String selectedDonutFlavorButtonToString = donutFlavor.getSelectedToggle().toString();
        String selectedDonutType = selectedDonutTypeButtonToString.substring(selectedDonutTypeButtonToString.indexOf("'") + 1, selectedDonutTypeButtonToString.lastIndexOf("'"));
        String selectedDonutFlavor = selectedDonutFlavorButtonToString.substring(selectedDonutFlavorButtonToString.indexOf("'") + 1, selectedDonutFlavorButtonToString.lastIndexOf("'"));
        Donut newDonutOrder = new Donut(selectedDonutType, selectedDonutFlavor);
        newDonutOrder.quantity = quantityOfOrder.getSelectionModel().getSelectedIndex() + 1;

        donutType.getSelectedToggle().setSelected(false);
        donutFlavor.getSelectedToggle().setSelected(false);

        return newDonutOrder;
    }

    @FXML
    void addToOrder() {

        if (donutType.getSelectedToggle() != null && donutFlavor.getSelectedToggle() != null) {

            boolean duplicateDonutFound = false;
            Donut newDonutOrder = createDonut();

            for (MenuItem num : shopMainMenuControllersDonut.getDonutCustomerOrder().getOrder()) {
                if (num.compare(newDonutOrder)) {

                    duplicateDonutFound = true;
                    num.quantity += newDonutOrder.quantity;
                    updateOrders();

                }
            }

            if (!duplicateDonutFound) {
                shopMainMenuControllersDonut.getDonutCustomerOrder().add(newDonutOrder);
                updateOrders();
            }
            totalOrderCost.setText(String.format("%.2f", shopMainMenuControllersDonut.getDonutCustomerOrder().orderPrice()));

        } else {
            createAlert();
        }
    }

    private void createAlert() {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("Donut Order is not valid");
        errorAlert.setContentText("Please make sure you've selected the Type & Flavor for the Donut(s)");
        errorAlert.showAndWait();
    }

    @FXML
    void removeFromOrder() {

        if (donutListView.getSelectionModel().getSelectedItem() != null) {
            shopMainMenuControllersDonut.getDonutCustomerOrder().remove(donutListView.getSelectionModel().getSelectedItem());
            updateOrders();
            totalOrderCost.setText(String.format("%.2f", shopMainMenuControllersDonut.getDonutCustomerOrder().orderPrice()));

        } else {
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
