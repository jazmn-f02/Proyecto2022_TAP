package sample.views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.models.EmpleadosDAO;

public class EmpleadosFRM extends Stage {

    private VBox vBox;
    private TextField txtNombre,txtApellidoP,txtApellidoM,txtRFC,txtSueldo,txtTelE,txtNssE,txtEmailE;
    private Label lblN,lblAP,lblAM,lblRFC,lblS,lblT,lblNSS,lblE;
    private Button btnSave;
    private Scene scene;
    private EmpleadosDAO objE;
    private TableView<EmpleadosDAO> tbvEmpleados;

    public EmpleadosFRM(TableView<EmpleadosDAO> tbv){
        this.tbvEmpleados=tbv;
        objE=new EmpleadosDAO();
        CrearUI();
        this.setTitle("Agregar Empleado");
        this.setScene(scene);
        this.show();
    }

    private void CrearUI() {
        vBox=new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));
        txtNombre=new TextField();
        lblN=new Label("Nombre:");
        txtApellidoP=new TextField();
        lblAP=new Label("Apellido Paterno:");
        txtApellidoM=new TextField();
        lblAM=new Label("Apellido Materno:");
        txtRFC=new TextField();
        lblRFC=new Label("RFC:");
        txtSueldo=new TextField();
        lblS=new Label("Sueldo:");
        txtTelE=new TextField();
        lblT=new Label("Teléfono:");
        txtNssE=new TextField();
        lblNSS=new Label("NSS:");
        txtEmailE=new TextField();
        lblE=new Label("Email:");
        btnSave=new Button("Guardar Empleado");
        btnSave.setOnAction(event -> {
            objE.setNombreE(txtNombre.getText());
            objE.setApellidoP(txtApellidoP.getText());
            objE.setApellidoM(txtApellidoM.getText());
            objE.setRfcE(txtRFC.getText());
            int s=Integer.parseInt(txtSueldo.getText());
            objE.setSueldo(s);
            objE.setTelE(txtTelE.getText());
            objE.setNssE(txtNssE.getText());
            objE.setEmailE(txtEmailE.getText());

            objE.Insertar();
            tbvEmpleados.setItems(objE.Seleccionar());
            tbvEmpleados.refresh();

            this.close();
        });

        vBox.getChildren().addAll(lblN,txtNombre,lblAP,txtApellidoP,lblAM,txtApellidoM,lblRFC,txtRFC,lblS,txtSueldo,
                lblT,txtTelE,lblNSS,txtNssE,lblE,txtEmailE,btnSave);
        scene=new Scene(vBox,255,500);
    }

}
