package sample;


import javafx.scene.control.TextField;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;


public class Controller {
    public TextField txt_bit;
    public TextField txt_elf;
    public TextField txt_bmm;
    private int a=1;
    public void initialize() throws IOException {
        if(a==1) {
            //JOptionPane.showMessageDialog(null, "initilize", "a", JOptionPane.WARNING_MESSAGE);

            String path_read=this.read_path("bmm_path.text");
            txt_bmm.setText(path_read);
            path_read=this.read_path("elf_path.text");
            txt_elf.setText(path_read);
            path_read=this.read_path("bit_path.text");
            txt_bit.setText(path_read);

            a=10;
        }
    }
    public void brows_bit(){
        FileChooser ff=new FileChooser();
        Stage stage=new Stage();
        ff.setTitle("select bit file");
        FileChooser.ExtensionFilter myFilter=new FileChooser.ExtensionFilter("BIT(*.bit)","*.bit");
        ff.getExtensionFilters().add(myFilter);

        File file=ff.showOpenDialog(stage);
        if(file!=null)
            txt_bit.setText(file.getPath());

    }
    public void brows_elf() {
        FileChooser ff=new FileChooser();
        Stage stage = new Stage();
        ff.setTitle("select elf file");

        FileChooser.ExtensionFilter myFilter=new FileChooser.ExtensionFilter("ELF(*.elf)","*.elf");
        ff.getExtensionFilters().addAll(myFilter);

        File elf_file=ff.showOpenDialog(stage);

        if(elf_file!=null)
            txt_elf.setText(elf_file.getPath());
    }

    public void brows_bmm( ) throws IOException {
        FileChooser ff=new FileChooser();
        Stage stage=new Stage();

        String path_read=this.read_path("bmm_path.text");

        ff.setTitle("select bmm file");
        FileChooser.ExtensionFilter myFilter=new FileChooser.ExtensionFilter("BMM(*.bmm)","*.bmm");
        ff.getExtensionFilters().addAll(myFilter);
        File file=ff.showOpenDialog(stage);
        if(file!=null){
            txt_bmm.setText(file.getPath());
            FileWriter fileWriterPath=new FileWriter("bmm_path.text");
            PrintWriter printWriter=new PrintWriter(fileWriterPath);
            printWriter.print(file.getPath());
            printWriter.close();
        }
        else{

        }
    }
    public String read_path(String path) throws IOException {
        File p=new File(path);

        if(!p.exists()) {
            JOptionPane.showMessageDialog(null,"incorrect path file","not found", JOptionPane.ERROR_MESSAGE);
        }
        else {
            BufferedReader f = new BufferedReader(new FileReader(path));
            String outputString;
            outputString = f.readLine() ;
            f.close();
            return outputString;
        }
        return null;


    }
}
