module com.danilo.escoladbfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.danilo.escoladbfx to javafx.fxml;
    exports com.danilo.escoladbfx.model;
    opens com.danilo.escoladbfx.model to javafx.fxml;
    exports com.danilo.escoladbfx.data;
    opens com.danilo.escoladbfx.data to javafx.fxml;
    exports com.danilo.escoladbfx;
    exports com.danilo.escoladbfx.controller;
    opens com.danilo.escoladbfx.controller to javafx.fxml;
}