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

    public void creat_bit_mouse() throws IOException {
//        String bit_path=path_maker(txt_bit.getText());
//        String elf_path=path_maker(txt_elf.getText());
//        String bmm_path=path_maker(txt_bmm.getText());
        String bit_path;
        String elf_path;
        String bmm_path;
        bit_path="a.bit";
        elf_path="a.elf";
        bmm_path="a.bmm";

//        JOptionPane.showMessageDialog(null,bit_path,"asd",JOptionPane.ERROR_MESSAGE);
//        JOptionPane.showMessageDialog(null,bmm_path,"asd",JOptionPane.ERROR_MESSAGE);
//        JOptionPane.showMessageDialog(null,elf_path,"asd",JOptionPane.ERROR_MESSAGE);
        //String str=(" data2mem -bm a.bmm -bd a.elf -bt a.bit -w");
        String str=(" data2mem -bm "+ bmm_path+ " -bd " +elf_path+ " -bt " +bit_path +" -w");
        Runtime cmd=Runtime.getRuntime();
        cmd.exec("cmd  /c start cmd.exe /K F:\\xilinx\\embeded_development_kit\\14.7\\ISE_DS\\settings64.bat "+str);
        }

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
            if(path_read!=null&&path_read!="\n")
                txt_bit.setText(path_read);
            else
                txt_bit.setText("please open a file");
            a=10;
        }
        if(!txt_bit.getText().equals("please open a file")){
            check_box_bit.setSelected(true);
            check_box_bit.setText("ok!");
        }
        if(!txt_elf.getText().equals("please open a file")){
            check_box_elf.setSelected(true);
            check_box_elf.setText("ok!");
        }
        if(!txt_bmm.getText().equals("please open a file")){
            check_box_bmm.setSelected(true);
            check_box_bmm.setText("ok!");

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
    public String path_maker(String path){
        path=path.replace("\\","\\\\");
        //JOptionPane.showMessageDialog(null,path,"asd",JOptionPane.ERROR_MESSAGE);

        return path;
    }
}
