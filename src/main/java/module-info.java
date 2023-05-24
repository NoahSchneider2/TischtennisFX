module com.example.tischtennisfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tischtennisfx to javafx.fxml;
    exports com.example.tischtennisfx;
    exports com.example.tischtennisfx.models;
    opens com.example.tischtennisfx.models to javafx.fxml;
    exports com.example.tischtennisfx.controller;
    opens com.example.tischtennisfx.controller to javafx.fxml;
}