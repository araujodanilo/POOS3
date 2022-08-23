module com.danilo.provacopadomundo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.danilo.provacopadomundo to javafx.fxml;
    exports com.danilo.provacopadomundo;
    exports com.danilo.provacopadomundo.data;
    opens com.danilo.provacopadomundo.data to javafx.fxml;
    exports com.danilo.provacopadomundo.model;
    opens com.danilo.provacopadomundo.model to javafx.fxml;
    exports com.danilo.provacopadomundo.controller;
    opens com.danilo.provacopadomundo.controller to javafx.fxml;
}