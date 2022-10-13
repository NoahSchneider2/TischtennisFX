module com.example.tischtennisfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tischtennisfx to javafx.fxml;
    exports com.example.tischtennisfx;
}