package rucafe.cs213project4;

import javafx.event.ActionEvent;
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

    private Order order;

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
    private Label totalOrderCost;

    @FXML
    private ToggleButton yeastDonut;

    @FXML
    public void initialize(){

        quantityOfOrder.getItems().addAll(ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,ELEVEN,TWELVE);

        quantityOfOrder.setValue(ONE);

        flavorChoiceOne.setText("Please");
        flavorChoiceTwo.setText("Pick");
        flavorChoiceThree.setText("A");
        flavorChoiceFour.setText("Donut");

    }



    @FXML
    void addToOrder(ActionEvent event) {

        //look at donuttype
        //look at donutflavor
        //look at quantity
        //create and put into order arraylist

        if (donutType.getSelectedToggle() != null && donutFlavor.getSelectedToggle() != null){

            //if here everything is filled out
            //god level java workaround

            String selectedDonutTypeButtonToString = donutType.getSelectedToggle().toString();

            String selectedDonutFlavorButtonToString = donutFlavor.getSelectedToggle().toString();

            String selectedDonutType = selectedDonutTypeButtonToString.substring(selectedDonutTypeButtonToString.indexOf("'")+1, selectedDonutTypeButtonToString.lastIndexOf("'"));

            String selectedDonutFlavor = selectedDonutFlavorButtonToString.substring(selectedDonutFlavorButtonToString.indexOf("'")+1, selectedDonutFlavorButtonToString.lastIndexOf("'"));

            Donut newDonutOrder = new Donut(selectedDonutType, selectedDonutFlavor);

            newDonutOrder.quantity = quantityOfOrder.getSelectionModel().getSelectedIndex()+1;

            //add to arraylist

            donutType.getSelectedToggle().setSelected(false);
            donutFlavor.getSelectedToggle().setSelected(false);


            //System.out.println(newDonutOrder.toString());

            order.add(newDonutOrder);

            System.out.println(order.getOrder().get(0));




        }else {
            //make pop up that says to populate
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Donut Order is not valid");
            errorAlert.setContentText("Please make sure you've selected the Type & Flavor for the Donut(s)");
            errorAlert.showAndWait();



        }




    }

    @FXML
    void DonutHolesSelected(ActionEvent event) {

        flavorChoiceOne.setText("Double Chocolate");
        flavorChoiceTwo.setText("Jelly Filled");
        flavorChoiceThree.setText("Oreo");
        flavorChoiceFour.setText("French");

    }

    @FXML
    void cakeDonutSelected(ActionEvent event) {

        flavorChoiceOne.setText("Red Velvet");
        flavorChoiceTwo.setText("Powder Sugar");
        flavorChoiceThree.setText("Baked Jelly");
        flavorChoiceFour.setText("Boston Cream");

    }

    @FXML
    void removeFromOrder(ActionEvent event) {

    }

    @FXML
    void yeastDonutSelected(ActionEvent event) {

        flavorChoiceOne.setText("Chocolate");
        flavorChoiceTwo.setText("Strawberry");
        flavorChoiceThree.setText("Cinnamon");
        flavorChoiceFour.setText("Coconut");

    }

}
