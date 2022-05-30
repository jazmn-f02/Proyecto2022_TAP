package sample.views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Taqueria extends Stage {

    private Scene scene;
    private HBox hBox, hBox2;
    private VBox vBox;
    private Button btnTacos, btnTortas, btnE, btnQ, btnB, btnG, btnV, btnC, btnP;
    private Image imgTacos, imgTortas, imgE, imgQ, imgB, imgG, imgV, imgC, imgP;
    private ImageView imvTacos, imvTortas, imvE, imvQ, imvB, imvG, imvV, imvC, imvP;

    public Taqueria(){
        CrearUI();
        this.setTitle("Taqueria");
        this.setScene(scene);
        this.show();
    }

    private void CrearUI() {
        imgTacos=new Image("sample/images/taco.png");
        imvTacos=new ImageView(imgTacos);
        imvTacos.setFitHeight(80);
        imvTacos.setFitWidth(80);
        btnTacos=new Button();
        btnTacos.setGraphic(imvTacos);
        btnTacos.setOnAction(event -> {
            new ClientesBD();
        });

        imgTortas=new Image("sample/images/torta.png");
        imvTortas=new ImageView(imgTortas);
        imvTortas.setFitHeight(80);
        imvTortas.setFitWidth(80);
        btnTortas=new Button();
        btnTortas.setOnAction(event -> {
            new TortasBD();
        });
        btnTortas.setGraphic(imvTortas);

        imgQ=new Image("sample/images/quesadilla.png");
        imvQ=new ImageView(imgQ);
        imvQ.setFitHeight(80);
        imvQ.setFitWidth(80);
        btnQ=new Button();
        btnQ.setGraphic(imvQ);

        imgE=new Image("sample/images/especialidad.png");
        imvE=new ImageView(imgE);
        imvE.setFitHeight(80);
        imvE.setFitWidth(80);
        btnE=new Button();
        btnE.setGraphic(imvE);

        imgB=new Image("sample/images/bebida.png");
        imvB=new ImageView(imgB);
        imvB.setFitHeight(80);
        imvB.setFitWidth(80);
        btnB=new Button();
        btnB.setGraphic(imvB);

        imgG=new Image("sample/images/guarnizo.png");
        imvG=new ImageView(imgG);
        imvG.setFitHeight(80);
        imvG.setFitWidth(80);
        btnG=new Button();
        btnG.setGraphic(imvG);

        imgV=new Image("sample/images/volcan.png");
        imvV=new ImageView(imgV);
        imvV.setFitHeight(80);
        imvV.setFitWidth(80);
        btnV=new Button();
        btnV.setGraphic(imvV);

        imgC=new Image("sample/images/costra.png");
        imvC=new ImageView(imgC);
        imvC.setFitHeight(80);
        imvC.setFitWidth(80);
        btnC=new Button();
        btnC.setGraphic(imvC);

        imgP=new Image("sample/images/postre.png");
        imvP=new ImageView(imgP);
        imvP.setFitHeight(80);
        imvP.setFitWidth(80);
        btnP=new Button();
        btnP.setGraphic(imvP);

        hBox=new HBox();
        hBox.setSpacing(20);
        hBox.setPadding(new Insets(10));
        hBox.getChildren().addAll(btnTacos, btnTortas, btnQ,btnV);
        hBox2=new HBox();
        hBox2.setSpacing(20);
        hBox2.setPadding(new Insets(10));
        hBox2.getChildren().addAll(btnC, btnG,btnB, btnP);
        vBox=new VBox();
        vBox.setSpacing(50);
        vBox.setPadding(new Insets(60));
        vBox.getChildren().addAll(hBox, hBox2);
        scene=new Scene(vBox,585,400);
    }
}
