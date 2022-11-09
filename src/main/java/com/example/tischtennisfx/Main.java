package com.example.tischtennisfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(Main.class.getResource("startWindow.fxml"));
        FXMLLoader fxmlLoader2 = new FXMLLoader(Main.class.getResource("mainWindow.fxml"));
        FXMLLoader fxmlLoader3 = new FXMLLoader(Main.class.getResource("showWindow.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load(), 620, 420);
        Scene scene2 = new Scene(fxmlLoader2.load(), 620, 420);
        Scene scene3 = new Scene(fxmlLoader3.load(), 620, 420);
        Stage stage2 = new Stage();

        startController startController = (startController) fxmlLoader1.getController();
        startController.setStage(stage);
        startController.setStage2(stage2);
        startController.setScene2(scene2);
        startController.setScene3(scene3);

        stage.setTitle("TischtennisTunier");
        stage.setScene(scene1);
        stage.show();

    }
    public void mainWindows(){

    }

    public static void main(String[] args) {
        launch();
    }
}