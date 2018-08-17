package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.security.PublicKey;

public class Controller {
    public TextField txt_bit;
    public TextField txt_elf;
    public TextField txt_bmm;


    public void brows_bit(MouseEvent mouseEvent){
        FileChooser ff=new FileChooser();
        Stage stage=new Stage();
        ff.setTitle("select bit file");
        FileChooser.ExtensionFilter myFilter=new FileChooser.ExtensionFilter("BIT(*.bit)","*.bit");
        ff.getExtensionFilters().add(myFilter);

        File file=ff.showOpenDialog(stage);
        if(file!=null)
            txt_bit.setText(file.getPath());

    }
    Scene scene=null;
    public void brows_elf(MouseEvent mouseEvent) throws IOException {
        FileChooser ff=new FileChooser();
        Stage stage = new Stage();
        ff.setTitle("select elf file");

        FileChooser.ExtensionFilter myFilter=new FileChooser.ExtensionFilter("ELF(*.elf)","*.elf");
        ff.getExtensionFilters().addAll(myFilter);

        File elf_file=ff.showOpenDialog(stage);

        if(elf_file!=null)
            txt_elf.setText(elf_file.getPath());
    }

    public void brows_bmm(MouseEvent mouseEvent) {
        FileChooser ff=new FileChooser();
        Stage stage=new Stage();

        ff.setTitle("select bmm file");
        FileChooser.ExtensionFilter myFilter=new FileChooser.ExtensionFilter("BMM(*.bmm)","*.bmm");
        ff.getExtensionFilters().addAll(myFilter);
        File file=ff.showOpenDialog(stage);
        if(file!=null)
            txt_bmm.setText(file.getPath());


    }
}
