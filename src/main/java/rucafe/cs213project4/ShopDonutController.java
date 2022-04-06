package rucafe.cs213project4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import static java.lang.Integer.parseInt;


public class ShopDonutController {

    public static final int INDEX_OF_YEAST_DONUT = 0;


    @FXML
    private ToggleButton cakeDonut;

    @FXML
    private ToggleGroup donutFlavor;

    @FXML
    private ToggleButton donutHoles;

    @FXML
    private ToggleGroup donutType;

    @FXML
    private TextField quantityOfOrder;

    @FXML
    private Label totalOrderCost;

    @FXML
    private ToggleButton yeastDonut;

    @FXML
    void DonutHolesSelected(ActionEvent event) {

    }

    @FXML
    void addToOrder(ActionEvent event) {
        //look at donuttype
        //look at donutflavor
        //look at quantity
        //create and put into order arraylist

        if (donutType.getSelectedToggle() != null && donutFlavor.getSelectedToggle() != null && !(quantityOfOrder.getText().equals(""))){

            //if here everything is filled out
            //god level java workaround

            String selectedDonutTypeButtonToString = donutType.getSelectedToggle().toString();

            String selectedDonutFlavorButtonToString = donutFlavor.getSelectedToggle().toString();

            String selectedDonutType = selectedDonutTypeButtonToString.substring(selectedDonutTypeButtonToString.indexOf("'")+1, selectedDonutTypeButtonToString.lastIndexOf("'"));

            String selectedDonutFlavor = selectedDonutFlavorButtonToString.substring(selectedDonutFlavorButtonToString.indexOf("'")+1, selectedDonutFlavorButtonToString.lastIndexOf("'"));

            Donut newDonutOrder = new Donut(selectedDonutType, selectedDonutFlavor);

            newDonutOrder.quantity = parseInt(quantityOfOrder.getText());

            //Order.addOrder(newDonutOrder);

            System.out.println(newDonutOrder.toString());

            
        }else {
            //make pop up that says to populate
            System.out.println("error please populate all fields");



        }

    }

    @FXML
    void cakeDonutSelected(ActionEvent event) {

    }

    @FXML
    void removeFromOrder(ActionEvent event) {

    }

    @FXML
    void yeastDonutSelected(ActionEvent event) {

    }

}
