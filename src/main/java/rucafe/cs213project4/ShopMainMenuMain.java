package rucafe.cs213project4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Class that creates a Stage from Application
 * in which the fxml file consisting of the GUI code
 * is set to and shown. The GUI is launched and
 * displayed.
 *
 * @author Mark Holleran, Abhitej Bokka
 */
public class ShopMainMenuMain extends Application {


    public ShopMainMenuMain(){}



    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ShopMainMenuMain.class.getResource("ShopMainMenuView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("RUCafe");
        stage.setScene(scene);
        stage.resizableProperty().setValue(false);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}

