module com.example.meadowfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.meadowfx to javafx.fxml;
    exports com.example.meadowfx;
}