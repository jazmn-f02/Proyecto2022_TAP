package sample.components;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import sample.models.ClientesDAO;

public class CustomeButtonCell extends TableCell<ClientesDAO, String> {

    private Button btnCelda;
    int opc;

    public CustomeButtonCell(int opc){
        this.opc=opc;
        if(opc==1)
            btnCelda=new Button("Editar");
        else
        btnCelda=new Button("Eliminar");
    }

    @Override
    protected void updateItem(String item, boolean empty){
        super.updateItem(item, empty);
        if(!empty){
            this.setGraphic(btnCelda);
        }
    }
}
