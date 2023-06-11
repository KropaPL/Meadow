module com.example.meadowfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires org.apache.commons.csv;


    opens com.example.meadowfx to javafx.fxml;
    exports com.example.meadowfx;
}