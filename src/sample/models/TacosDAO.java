package sample.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TacosDAO {
    private  int idTaco;
    private String desc;
    private Double precio;

    public int getIdTaco() {
        return idTaco;
    }

    public void setIdTaco(int idTaco) {
        this.idTaco = idTaco;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public ObservableList<TacosDAO> Seleccionar(){

        ObservableList<TacosDAO> listaT = FXCollections.observableArrayList();
        TacosDAO objT;
        String query = "SELECT * FROM tacos ORDER BY idTaco";
        try {
            Statement stmt = Conexion.conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while( res.next() ){
                objT = new TacosDAO();
                objT.setIdTaco(res.getInt("idTaco"));
                objT.setDesc(res.getString("descripcion"));
                objT.setPrecio(res.getDouble("Precio"));
                listaT.add(objT);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaT;

    }
}
