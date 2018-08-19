package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("microblaze programmer");
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("sample/icon.png"));


        primaryStage.show();

    }




    public static void main(String[] args) {
        launch(args);
    }
}
