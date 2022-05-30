package sample.views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.components.Corredor;

public class Pista extends Stage {

    private Scene scene;
    private VBox vBox;
    private Button btnRun;
    private ProgressBar[] pgbCarriles=new ProgressBar[10];
    private String[] arrName={"Correcaminos","Alfredo Adame","Speedy Gonzalez","Darth Vader","Pedrito Sola","Chuponcito",
            "Paty Chapoy","Chabelo","Goku","Pikachu"};
    private Corredor[] thrCorredores=new Corredor[arrName.length];


    public Pista(){
        CrearUI();
        this.setTitle("Pista de Atletismo");
        this.setScene(scene);
        this.show();
    }

    private void CrearUI() {
        vBox=new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));
        for (int i = 0; i < arrName.length; i++) {
            pgbCarriles[i]=new ProgressBar(0);
            thrCorredores[i]=new Corredor(arrName[i],pgbCarriles[i]);
            vBox.getChildren().add(pgbCarriles[i]);
        }
        btnRun=new Button("Iniciar");
        btnRun.setOnAction(event -> {
            for (int i = 0; i < arrName.length; i++) {
                thrCorredores[i].start();
            }
        });
        vBox.getChildren().add(btnRun);
        scene=new Scene(vBox,265,320);
    }
}
