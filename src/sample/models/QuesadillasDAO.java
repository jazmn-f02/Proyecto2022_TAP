package sample.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuesadillasDAO extends Stage {
    private int idQ;
    private String desc;
    private double precio;

    public int getIdQ() {
        return idQ;
    }

    public void setIdQ(int idQ) {
        this.idQ = idQ;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ObservableList<QuesadillasDAO> Seleccionar(){

        ObservableList<QuesadillasDAO> listaQ = FXCollections.observableArrayList();
        QuesadillasDAO objQ;
        String query = "SELECT * FROM quesadillas ORDER BY idQuesadilla";
        try {
            Statement stmt = Conexion.conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while( res.next() ){
                objQ = new QuesadillasDAO();
                objQ.setIdQ(res.getInt("idQuesadilla"));
                objQ.setDesc(res.getString("descripcion"));
                objQ.setPrecio(res.getDouble("precio"));
                listaQ.add(objQ);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaQ;
    }
}
