module com.example.rp5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rp5 to javafx.fxml;
    exports com.example.rp5;
}