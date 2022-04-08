package rucafe.cs213project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ShopMainMenuController {

    @FXML
    private Button orderCoffee;

    @FXML
    private Button orderDonut;

    @FXML
    private Button displayCurrentOrder;

    @FXML
    private Button displayAllOrders;

    private int runningUniqueOrderNumber = 0;
    public int getUniqueOrderNumber(){

        ++runningUniqueOrderNumber;

        return runningUniqueOrderNumber;
    }

    private StoreOrders storeOrders = new StoreOrders();
    private Order donutCustomerOrder = new Order();
    private Order CoffeeCustomerOrder = new Order();
    private Order totalCustomerOrder = new Order();

    //all instance variables in controllers should be private
    //this (the primary stage) must remain visible while navigating between guis

    public ObservableList<Order> getStoreOrderObservableList(){
        return storeOrders.getOrderList();
    }

    public Order getTotalCustomerOrder() {
        return totalCustomerOrder;
    }

    public ObservableList<MenuItem> getOrderObservableList(){

        totalCustomerOrder = new Order();

        totalCustomerOrder.getOrder().addAll(getCoffeeCustomerOrder().getOrder());
        totalCustomerOrder.getOrder().addAll(getDonutCustomerOrder().getOrder());

        return this.totalCustomerOrder.getOrder();
    }


    public Order getDonutCustomerOrder(){
        return donutCustomerOrder;
    }

    public Order getCoffeeCustomerOrder(){

        return CoffeeCustomerOrder;
    }

    public StoreOrders getStoreOrders(){return storeOrders;}


    @FXML
    void displayAllOrders(ActionEvent event) {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(ShopMainMenuMain.class.getResource("StoreOrdersView.fxml"));
            Parent root1 = (Parent) (fxmlLoader.load());
            StoreOrdersController StoreOrdersController = fxmlLoader.getController();
            StoreOrdersController.createShopMainMenuController(this);
            Stage stage = new Stage();
            stage.setTitle("Store Orders");
            stage.setScene(new Scene(root1));

            stage.resizableProperty().setValue(false);
            disableAllButtons();
            stage.show();

            stage.setOnCloseRequest(eventCalled -> enableAllButtons());


        } catch (Exception e) {

            System.err.println(e.getMessage());
        }


    }

    @FXML
    void displayCurrentOrder(ActionEvent event) {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(ShopMainMenuMain.class.getResource("OrderingBasketView.fxml"));
            Parent root1 = (Parent) (fxmlLoader.load());
            OrderingBasketController orderingBasketController = fxmlLoader.getController();
            orderingBasketController.createShopMainMenuController(this);
            Stage stage = new Stage();
            stage.setTitle("Current Order");
            stage.setScene(new Scene(root1));
            stage.resizableProperty().setValue(false);
            disableAllButtons();
            stage.show();

            stage.setOnCloseRequest(eventCalled -> enableAllButtons());




        } catch (Exception e) {

            System.err.println(e.getMessage());
        }



    }

    public void disableNotCoffee(){
        orderDonut.setDisable(true);
        displayAllOrders.setDisable(true);
        displayCurrentOrder.setDisable(true);
    }

    public void disableNotDonut(){
        orderCoffee.setDisable(true);
        displayAllOrders.setDisable(true);
        displayCurrentOrder.setDisable(true);
    }

    public void disableNotCurrent(){
        orderDonut.setDisable(true);
        orderCoffee.setDisable(true);
        displayAllOrders.setDisable(true);
    }

    public void disableNotAll(){
        orderDonut.setDisable(true);
        orderCoffee.setDisable(true);
        displayCurrentOrder.setDisable(true);
    }

    public void enableAllButtons(){
        orderDonut.setDisable(false);
        orderCoffee.setDisable(false);
        displayAllOrders.setDisable(false);
        displayCurrentOrder.setDisable(false);
    }

    public void disableAllButtons(){
        orderDonut.setDisable(true);
        orderCoffee.setDisable(true);
        displayAllOrders.setDisable(true);
        displayCurrentOrder.setDisable(true);
    }

    @FXML
    void orderCoffee(ActionEvent event) {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ShopCoffeeView.fxml"));
            Parent root1 = (Parent) (fxmlLoader.load()); // BorderPane pizzaCustomizer = (BorderPane) loader.load();
            ShopCoffeeController ShopCoffeeController = fxmlLoader.getController();
            ShopCoffeeController.createShopMainMenuController(this);
            Stage stage = new Stage();
            stage.setTitle("Order a Coffee");
            stage.setScene(new Scene(root1));
            stage.resizableProperty().setValue(false);
            disableAllButtons();
            stage.show();

            stage.setOnCloseRequest(eventCalled -> enableAllButtons());





        } catch (Exception e) {

            System.err.println(e.getMessage());
        }





    }

    @FXML
    void orderDonut(ActionEvent event) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ShopDonutView.fxml"));
            Parent root1 = (Parent) (fxmlLoader.load()); // BorderPane pizzaCustomizer = (BorderPane) loader.load();
            ShopDonutController shopDonutController = fxmlLoader.getController();
            shopDonutController.createShopMainMenuController(this);
            Stage stage = new Stage();
            stage.setTitle("Order a Donut");
            stage.setScene(new Scene(root1));
            stage.resizableProperty().setValue(false);
            disableAllButtons();
            stage.show();

            stage.setOnCloseRequest(eventCalled -> enableAllButtons());



        } catch (Exception e) {

            System.err.println(e.getMessage());
        }

    }
}
