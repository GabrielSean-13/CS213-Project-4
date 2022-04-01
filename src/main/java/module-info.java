module rucafe.cs213project4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens rucafe.cs213project4 to javafx.fxml;
    exports rucafe.cs213project4;
}