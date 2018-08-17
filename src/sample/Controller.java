package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.security.PublicKey;

public class Controller {
    public Label label_bmm;
    public Label label_bit;
    public Label label_elf;

    public void brows_bit(MouseEvent mouseEvent){
        label_bit.setText("clicked");

    }
    Scene scene=null;
    Parent a;
    FileChooser ff=new FileChooser();
    public void brows_elf(MouseEvent mouseEvent) throws IOException {
        label_elf.setText("clicked");
        a = FXMLLoader.load(getClass().getResource("file_browser.fxml"));
        Stage stage = new Stage();
        stage.show();
        ff.showOpenDialog(stage);

    }

    public void brows_bmm(MouseEvent mouseEvent) {
        label_bmm.setText("clicked");

    }
}
