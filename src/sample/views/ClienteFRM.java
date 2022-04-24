package sample.views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.models.ClientesDAO;

public class ClienteFRM extends Stage {

    private VBox vBox;
    private TextField txtNombre, txtTelefono, txtDireccion;
    private Label lblN, lblT, lblD;
    private Button btnSave;
    private Scene scene;
    private ClientesDAO objC;
    private TableView<ClientesDAO> tbvClientes;

    public ClienteFRM(TableView<ClientesDAO> tbv){
        this.tbvClientes=tbv;
        objC=new ClientesDAO();
        CrearUI();
        this.setTitle("Agregar Cliente");
        this.setScene(scene);
        this.show();
    }

    private void CrearUI(){
        vBox=new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));
        txtNombre=new TextField();
        lblN=new Label("Nombre:");
        txtTelefono =new TextField();
        lblT=new Label("Teléfono:");
        txtDireccion =new TextField();
        lblD=new Label("Dirección:");
        btnSave=new Button("Guardar Cliente");
        btnSave.setOnAction(event -> {
            objC.setNombreC(txtNombre.getText());
            objC.setTelC(txtTelefono.getText());
            objC.setDireccionC(txtDireccion.getText());
            objC.Insertar();

            tbvClientes.setItems(objC.Seleccionar());
            tbvClientes.refresh();
            this.close();
        });

        vBox.getChildren().addAll(lblN,txtNombre, lblT, txtTelefono,lblD, txtDireccion, btnSave);
        scene=new Scene(vBox,250,230);
    }


}
