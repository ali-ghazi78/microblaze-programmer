package sample;

import javafx.fxml.FXMLLoader;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.Parent;
import java.io.IOException;

public class FileBrowser  {
    Parent a;
    public void start()throws IOException{
         a = FXMLLoader.load(getClass().getClassLoader().getResource("file_browser.fxml"));
        Stage stage = new Stage();
        stage.setTitle("My New Stage Title");
        stage.setScene(new Scene(a, 450, 450));
        stage.show();
        // Hide this current window (if this is what you want)
    }

}
