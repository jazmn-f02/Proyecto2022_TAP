package sample.views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.models.TortasDAO;

public class TortasBD extends Stage {
    private Scene scene;
    private TableView<TortasDAO> tbvTortas;
    private VBox vBox;
    private TortasDAO tortasDAO;

    public TortasBD(){
        tortasDAO=new TortasDAO();
        CrearUI();
        this.setTitle("Tortas");
        this.setScene(scene);
        this.show();
    }

    private void CrearUI() {
        tbvTortas=new TableView<>();
        vBox=new VBox();
        vBox.setPadding(new Insets(10));
        vBox.getChildren().add(tbvTortas);
        scene=new Scene(vBox,600,250);

        crearTabla();
    }

    private void crearTabla() {
        TableColumn<TortasDAO,Integer> tbcIdTorta=new TableColumn<>("idTorta");
        tbcIdTorta.setCellValueFactory(new PropertyValueFactory<>("idTorta"));

        TableColumn<TortasDAO,String> tbcDescripcion=new TableColumn<>("Descripcion");
        tbcDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));

        TableColumn<TortasDAO,Double> tbcPrecio=new TableColumn<>("Precio");
        tbcPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        TableColumn<TortasDAO,String> tbcOrdenar=new TableColumn<>("+");
        tbcOrdenar.setCellFactory(new Callback<TableColumn<TortasDAO, String>, TableCell<TortasDAO, String>>() {
            @Override
            public TableCell<TortasDAO, String> call(TableColumn<TortasDAO, String> param) {
                return null;
            }
        });

        TableColumn<TortasDAO,String> tbcQuitar=new TableColumn<>("-");
        tbcQuitar.setCellFactory(new Callback<TableColumn<TortasDAO, String>, TableCell<TortasDAO, String>>() {
            @Override
            public TableCell<TortasDAO, String> call(TableColumn<TortasDAO, String> param) {
                return null;
            }
        });

        tbvTortas.getColumns().addAll(tbcIdTorta,tbcDescripcion,tbcPrecio,tbcOrdenar,tbcQuitar);
        tbvTortas.setItems(tortasDAO.Seleccionar());
    }
}
