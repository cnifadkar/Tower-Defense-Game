module com.example.mainscreen {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens com.example.mainscreen to javafx.fxml;
    exports com.example.mainscreen;
}