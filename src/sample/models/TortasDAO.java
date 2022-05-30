package sample.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TortasDAO {
    private int idTorta;
    private String descripcion;
    private double precio;

    public int getIdTorta() {
        return idTorta;
    }

    public void setIdTorta(int idTorta) {
        this.idTorta = idTorta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ObservableList<TortasDAO> Seleccionar(){

        ObservableList<TortasDAO> listaT = FXCollections.observableArrayList();
        TortasDAO objC;
        String query = "SELECT * FROM tortas ORDER BY idTorta";
        try {
            Statement stmt = Conexion.conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while( res.next() ){
                objC = new TortasDAO();
                objC.setIdTorta(res.getInt("idTorta"));
                objC.setDescripcion(res.getString("descripcion"));
                objC.setPrecio(res.getDouble("precio"));
                listaT.add(objC);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaT;
    }
}
