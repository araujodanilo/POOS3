module com.danilo.provacopadomundo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.danilo.provacopadomundofx to javafx.fxml;
    exports com.danilo.provacopadomundofx;
    exports com.danilo.provacopadomundofx.data;
    opens com.danilo.provacopadomundofx.data to javafx.fxml;
    exports com.danilo.provacopadomundofx.model;
    opens com.danilo.provacopadomundofx.model to javafx.fxml;
    exports com.danilo.provacopadomundofx.controller;
    opens com.danilo.provacopadomundofx.controller to javafx.fxml;
}