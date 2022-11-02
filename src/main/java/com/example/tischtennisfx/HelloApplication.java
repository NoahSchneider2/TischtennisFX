package com.example.tischtennisfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("inputWindow.fxml"));
        FXMLLoader fxmlLoader3 = new FXMLLoader(HelloApplication.class.getResource("showWindow.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load(), 620, 420);
        Scene scene2 = new Scene(fxmlLoader2.load(), 620, 420);
        Scene scene3 = new Scene(fxmlLoader3.load(), 620, 420);
        stage.setTitle("Hello!");
        stage.setScene(scene3);
        stage.show();
    }
    public void mainWindows(){

    }

    public static void main(String[] args) {
        launch();
    }
}