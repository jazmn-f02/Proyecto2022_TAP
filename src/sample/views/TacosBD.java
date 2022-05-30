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
import sample.models.TacosDAO;

public class TacosBD extends Stage {
    private Scene scene;
    private TableView<TacosDAO> tbvTacos;
    private VBox vBox;
    private TacosDAO tacosDAO;

    public TacosBD() {
        tacosDAO = new TacosDAO();
        CrearUI();
        this.setTitle("Tacos");
        this.setScene(scene);
        this.show();
    }

    private void CrearUI() {
        tbvTacos = new TableView<>();
        vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));
        vBox.getChildren().add(tbvTacos);
        scene = new Scene(vBox,700,250);

        CrearTabla();
    }

    private void CrearTabla() {
        TableColumn<TacosDAO,Integer> tbcIdTaco = new TableColumn<>("ID");
        tbcIdTaco.setCellValueFactory(new PropertyValueFactory<>("idTaco"));

        TableColumn<TacosDAO,String> tbcDesc = new TableColumn<>("Descripcion");
        tbcDesc.setCellValueFactory(new PropertyValueFactory<>("descripcion"));

        TableColumn<TacosDAO,String> tbcPrecio = new TableColumn<>("Precio");
        tbcPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        TableColumn<TacosDAO, String> tbcOrdenar=new TableColumn<>("+");
        tbcOrdenar.setCellFactory(new Callback<TableColumn<TacosDAO, String>, TableCell<TacosDAO, String>>() {
            @Override
            public TableCell<TacosDAO, String> call(TableColumn<TacosDAO, String> param) {
                return null;
            }
        });

        TableColumn <TacosDAO, String> tbcQuitar = new TableColumn<>("-");
        tbcQuitar.setCellFactory(new Callback<TableColumn<TacosDAO, String>, TableCell<TacosDAO, String>>() {
            @Override
            public TableCell<TacosDAO, String> call(TableColumn<TacosDAO, String> param) {
                return null;
            }
        });

        tbvTacos.getColumns().addAll(tbcIdTaco, tbcDesc, tbcPrecio, tbcOrdenar, tbcQuitar);
        tbvTacos.setItems(tacosDAO.Seleccionar());
    }
}
