package sample.views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.components.CustomeButtonCell;
import sample.models.ClientesDAO;

public class ClientesBD extends Stage{

    private Scene escena;
    private TableView<ClientesDAO> tbvClientes;
    private Button btnAgregar;
    private VBox vBox;
    private ClientesDAO clientesDAO;

    public ClientesBD(){
        clientesDAO = new ClientesDAO();
        CrearUI();
        this.setTitle("Clientes Taqueria :)");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        tbvClientes = new TableView<>();
        btnAgregar=new Button("Agregar Cliente");
        btnAgregar.setOnAction(event -> {
            new ClienteFRM(tbvClientes);
        });
        vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(tbvClientes,btnAgregar);
        escena = new Scene(vBox,700,250);
        
        CrearTabla();
    }

    private void CrearTabla() {
        TableColumn<ClientesDAO,Integer> tbcCveCliente = new TableColumn<>("Clave");
        tbcCveCliente.setCellValueFactory(new PropertyValueFactory<>("cveCliente"));

        TableColumn<ClientesDAO,String> tbcNombreC = new TableColumn<>("Nombre");
        tbcNombreC.setCellValueFactory(new PropertyValueFactory<>("nombreC"));

        TableColumn<ClientesDAO,String> tbcTelC = new TableColumn<>("Teléfono");
        tbcTelC.setCellValueFactory(new PropertyValueFactory<>("telC"));

        TableColumn<ClientesDAO,String> tbcDireccionC = new TableColumn<>("Dirección");
        tbcDireccionC.setCellValueFactory(new PropertyValueFactory<>("direccionC"));

        TableColumn<ClientesDAO, String> tbcEditar=new TableColumn<>("Editar");
        tbcEditar.setCellFactory(new Callback<TableColumn<ClientesDAO, String>, TableCell<ClientesDAO, String>>() {
            @Override
            public TableCell<ClientesDAO, String> call(TableColumn<ClientesDAO, String> param) {
                return new CustomeButtonCell(1);
            }
        });

        TableColumn<ClientesDAO, String> tbcEliminar=new TableColumn<>("Eliminar");
        tbcEliminar.setCellFactory(new Callback<TableColumn<ClientesDAO, String>, TableCell<ClientesDAO, String>>() {
            @Override
            public TableCell<ClientesDAO, String> call(TableColumn<ClientesDAO, String> param) {
                return new CustomeButtonCell(2);
            }
        });

        tbvClientes.getColumns().addAll(tbcCveCliente,tbcNombreC,tbcTelC,tbcDireccionC,tbcEditar,tbcEliminar);
        tbvClientes.setItems(clientesDAO.Seleccionar());

    }


}
