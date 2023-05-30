package com.example.meadowfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Meadow");
        Image icon = new Image("C:\\Users\\natal\\Desktop\\Programowanie\\MeadowFx\\src\\main\\resources\\com\\example\\meadowfx\\ikona.jpg");
        stage.getIcons().add(icon);
        stage.setHeight(430);
        stage.setWidth(620);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}