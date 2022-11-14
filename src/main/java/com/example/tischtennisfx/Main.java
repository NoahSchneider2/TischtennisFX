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

        Scene scene1 = new Scene(fxmlLoader1.load(), 620, 420);
        stage.setTitle("Tabletennisturnier - Mannschaftseingabe");
        SetupController setupController = (SetupController) fxmlLoader1.getController();
        setupController.setStageOne(stage);
        stage.setScene(scene1);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}