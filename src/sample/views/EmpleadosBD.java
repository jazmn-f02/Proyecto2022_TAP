package sample.views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.models.EmpleadosDAO;

public class EmpleadosBD extends Stage {

    private Scene scene;
    private TableView<EmpleadosDAO> tbvEmpleados;
    private Button btnAgregar;
    private VBox vBox;
    private EmpleadosDAO empleadosDAO;

    public EmpleadosBD (){
        empleadosDAO=new EmpleadosDAO();
        CrearUI();
        this.setTitle("Empleados Taqueria");
        this.setScene(scene);
        this.show();
    }

    private void CrearUI() {
        tbvEmpleados = new TableView<>();
        btnAgregar=new Button("Agregar Empleado");
        btnAgregar.setOnAction(event -> {
            new EmpleadosFRM(tbvEmpleados);
        });
        vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(tbvEmpleados,btnAgregar);
        scene = new Scene(vBox,743,250);

        CrearTabla();
    }

    private void CrearTabla() {
        TableColumn<EmpleadosDAO,Integer> tbcCveEmpleado=new TableColumn<>("Clave");
        tbcCveEmpleado.setCellValueFactory(new PropertyValueFactory<>("cveEmpleado"));

        TableColumn<EmpleadosDAO,String> tbcNombreE=new TableColumn<>("Nombre");
        tbcNombreE.setCellValueFactory(new PropertyValueFactory<>("nombreE"));

        TableColumn<EmpleadosDAO,String> tbcApellidoP=new TableColumn<>("Apellido Paterno");
        tbcApellidoP.setCellValueFactory(new PropertyValueFactory<>("apellidoPatE"));

        TableColumn<EmpleadosDAO,String> tbcApellidoM=new TableColumn<>("Apellido Materno");
        tbcApellidoM.setCellValueFactory(new PropertyValueFactory<>("apellidoMatE"));

        TableColumn<EmpleadosDAO,String> tbcRFC=new TableColumn<>("RFC");
        tbcRFC.setCellValueFactory(new PropertyValueFactory<>("rfcE"));

        TableColumn<EmpleadosDAO,Double> tbcSueldo=new TableColumn<>("Sueldo");
        tbcSueldo.setCellValueFactory(new PropertyValueFactory<>("sueldo"));

        TableColumn<EmpleadosDAO,String> tbcTelE=new TableColumn<>("Teléfono");
        tbcTelE.setCellValueFactory(new PropertyValueFactory<>("telE"));

        TableColumn<EmpleadosDAO,String> tbcNssE=new TableColumn<>("NSS");
        tbcNssE.setCellValueFactory(new PropertyValueFactory<>("nssE"));

        TableColumn<EmpleadosDAO,String> tbcEmailE=new TableColumn<>("Email");
        tbcEmailE.setCellValueFactory(new PropertyValueFactory<>("emailE"));

        /*TableColumn<EmpleadosDAO, String> tbcEditar=new TableColumn<>("Editar");
        tbcEditar.setCellFactory(new Callback<TableColumn<EmpleadosDAO, String>, TableCell<EmpleadosDAO, String>>() {
            @Override
            public TableCell<EmpleadosDAO, String> call(TableColumn<EmpleadosDAO, String> param) {
                return new CustomeButtonCell(1);
            }
        });

        TableColumn<EmpleadosDAO, String> tbcEliminar=new TableColumn<>("Eliminar");
        tbcEliminar.setCellFactory(new Callback<TableColumn<EmpleadosDAO, String>, TableCell<EmpleadosDAO, String>>() {
            @Override
            public TableCell<EmpleadosDAO, String> call(TableColumn<EmpleadosDAO, String> param) {
                return new CustomeButtonCell(2);
            }
        });*/

        tbvEmpleados.getColumns().addAll(tbcCveEmpleado,tbcNombreE,tbcApellidoP,tbcApellidoM,tbcRFC,tbcSueldo,tbcTelE,tbcNssE,tbcEmailE);
        tbvEmpleados.setItems(empleadosDAO.Seleccionar());
    }
}
