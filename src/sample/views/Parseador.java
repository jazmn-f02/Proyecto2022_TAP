package sample.views;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.events.EventoParsero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Parseador extends Stage implements EventHandler<KeyEvent> {

    private VBox vBox;
    private ToolBar tlbMenu;
    private TextArea txtEntrada, txtSalida;
    private FileChooser flcArchivo;
    private Button btnAbrir, btnTrad;
    private Scene escena;
    private Image imgAbrir, imgTrad;
    private ImageView imvAbrir, imvTrad;
    private String words="";

    public Parseador(){

        CrearUI();
        this.setTitle("Traductor de Código Morse");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        vBox = new VBox();
        tlbMenu = new ToolBar();
        imgAbrir = new Image("sample/images/7265_mail_open_icon.png");
        imvAbrir = new ImageView(imgAbrir);
        imvAbrir.setFitHeight(50);
        imvAbrir.setFitWidth(50);
        btnAbrir = new Button();
        btnAbrir.setGraphic(imvAbrir);
        btnAbrir.setOnAction(event -> {
           // aqui va el código
            flcArchivo = new FileChooser();
            flcArchivo.setTitle("Buscar archivo...");
            File archivo = flcArchivo.showOpenDialog(this);
            try {
                BufferedReader read=new BufferedReader(new FileReader(archivo));
                String text="";
                String line="";
                while((line=read.readLine())!=null){
                    text+=line+"\n";
                }
                txtSalida.setText(text);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        //....
        txtSalida = new TextArea();
        txtSalida.setPromptText("Escribe el texto a traducir");
        txtSalida.setOnKeyPressed(this);
        txtEntrada = new TextArea();
        txtEntrada.setEditable(false);
        imgTrad = new Image("sample/images/traductor.png");
        imvTrad = new ImageView(imgAbrir);
        imvTrad.setFitHeight(50);
        imvTrad.setFitWidth(50);
        btnTrad = new Button();
        btnTrad.setGraphic(imvTrad);
        btnTrad.setOnAction(event -> {
            EventoParsero parsero = new EventoParsero();
            words = parsero.traductor(txtSalida.getText());
            txtEntrada.setText(words);
        });

        tlbMenu.getItems().addAll(btnAbrir);
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(5));
        vBox.getChildren().addAll(tlbMenu,txtEntrada,txtSalida,btnTrad);
        escena = new Scene(vBox,500,300);
    }


    @Override
    public void handle(KeyEvent e) {
        System.out.println(e.getCode().toString());
    }
}
