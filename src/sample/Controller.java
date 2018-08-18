package sample;


import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

import java.io.*;


public class Controller {
    public TextField txt_bit;
    public TextField txt_elf;
    public TextField txt_bmm;
    public CheckBox check_box_bmm;
    public CheckBox check_box_bit;
    public CheckBox check_box_elf;

    private int a=1;
    public void initialize() throws IOException {
        if(a==1) {
            //JOptionPane.showMessageDialog(null, "initilize", "a", JOptionPane.WARNING_MESSAGE);

            String path_read=this.read_path("bmm_path.text");
            if(path_read!=null)
                txt_bmm.setText(path_read);
            else
                txt_bmm.setText("please open a file");
            path_read=this.read_path("elf_path.text");
            if(path_read!=null)
                txt_elf.setText(path_read);
            else
                txt_elf.setText("please open a file");

            path_read=this.read_path("bit_path.text");
            if(path_read!=null)
                txt_bit.setText(path_read);
            else
                txt_bit.setText("please open a file");
            a=10;
        }
        if(!txt_bit.getText().equals("please open a file")){
            check_box_bit.setSelected(false);
        }
        if(!txt_elf.getText().equals("please open a file")){
            check_box_elf.setSelected(false);
        }
        if(!txt_bmm.getText().equals("please open a file")){
            check_box_bmm.setSelected(false);

        }
    }
    public void brows_bit() throws IOException {
        FileChooser ff=new FileChooser();
        Stage stage=new Stage();
        ff.setTitle("select bit file");
        FileChooser.ExtensionFilter myFilter=new FileChooser.ExtensionFilter("BIT(*.bit)","*.bit");
        ff.getExtensionFilters().add(myFilter);

        File file=ff.showOpenDialog(stage);
        if(file!=null) {
            txt_bit.setText(file.getPath());
            FileWriter fileWriterPath=new FileWriter("bit_path.text");
            PrintWriter printWriter=new PrintWriter(fileWriterPath);
            printWriter.print(file.getPath());
            printWriter.close();


        }

    }
    public void brows_elf() throws IOException {
        FileChooser ff=new FileChooser();
        Stage stage = new Stage();
        ff.setTitle("select elf file");

        FileChooser.ExtensionFilter myFilter=new FileChooser.ExtensionFilter("ELF(*.elf)","*.elf");
        ff.getExtensionFilters().addAll(myFilter);

        File file=ff.showOpenDialog(stage);
        if(file!=null) {
            txt_elf.setText(file.getPath());
            FileWriter fileWriterPath=new FileWriter("elf_path.text");
            PrintWriter printWriter=new PrintWriter(fileWriterPath);
            printWriter.print(file.getPath());
            printWriter.close();


        }
    }

    public void brows_bmm( ) throws IOException {
        FileChooser ff=new FileChooser();
        Stage stage=new Stage();

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
