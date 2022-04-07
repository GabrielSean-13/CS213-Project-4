package rucafe.cs213project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ShopMainMenuController {

    private StoreOrders storeOrders = new StoreOrders();
    private Order order = new Order();

    //all instance variables in controllers should be private
    //this (the primary stage) must remain visible while navigating between guis


    public ArrayList<Order> getStoreOrderArrayList(){
        return this.storeOrders.getOrderArrayList();
    }

    public void setStoreOrderArrayList(ArrayList<Order> orders){
        storeOrders.setOrderArrayList(orders);
    }

    public Order getOrder(){
        return order;
    }

    public void setOrder(Order order){
        this.order = order;
    }




    @FXML
    void displayAllOrders(ActionEvent event) {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(ShopMainMenuMain.class.getResource("StoreOrdersView.fxml"));
            Parent root1 = (Parent) (fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Store Orders");
            stage.setScene(new Scene(root1));

            stage.resizableProperty().setValue(false);

            stage.show();


        } catch (Exception e) {

            System.err.println(e.getMessage());
        }


    }

    @FXML
    void displayCurrentOrder(ActionEvent event) {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(ShopMainMenuMain.class.getResource("OrderingBasketView.fxml"));
            Parent root1 = (Parent) (fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Current Order");
            stage.setScene(new Scene(root1));
            stage.resizableProperty().setValue(false);
            stage.show();


        } catch (Exception e) {

            System.err.println(e.getMessage());
        }



    }

    @FXML
    void orderCoffee(ActionEvent event) {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(ShopMainMenuMain.class.getResource("ShopCoffeeView.fxml"));
            Parent root1 = (Parent) (fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Order a Coffee");
            stage.setScene(new Scene(root1));
            stage.resizableProperty().setValue(false);
            stage.show();

            //Create coffee instance


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
            stage.show();

        /*
            FXMLLoader fxmlLoader = new FXMLLoader(ShopMainMenuMain.class.getResource("ShopDonutView.fxml"));
            Parent root1 = (Parent) (fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Order a Donut");
            stage.setScene(new Scene(root1));
            stage.resizableProperty().setValue(false);
            createShopMainMenuController(shopMainMenuController);
            stage.show();
        */

        } catch (Exception e) {

            System.err.println(e.getMessage());
        }

    }
}
