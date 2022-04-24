package sample.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientesDAO {

    private int cveCliente;
    private String nombreC;
    private String telC;
    private String direccionC;

    public int getCveCliente() {
        return cveCliente;
    }

    public void setCveCliente(int cveCliente) {
        this.cveCliente = cveCliente;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public String getTelC() {
        return telC;
    }

    public void setTelC(String telC) {
        this.telC = telC;
    }

    public String getDireccionC() {
        return direccionC;
    }

    public void setDireccionC(String direccionC) {
        this.direccionC = direccionC;
    }

    public void Insertar(){
        String query = "INSERT INTO Clientes (nombreC,telC,direccionC) " +
                "VALUES('"+this.nombreC +"','"+this.telC +"','"+this.direccionC +"')";
        try {
            Statement stmt = Conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Actualizar(){
        String query = "UPDATE Clientes SET nombreC='"+this.nombreC +"',telC='"+this.telC +"'," +
                "direccionC='"+this.direccionC +"' WHERE cveCliente = "+this.cveCliente;
        try {
            Statement stmt = Conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Eliminar(){
        String query = "DELETE FROM Clientes WHERE cveCliente = "+this.cveCliente;
        try {
            Statement stmt = Conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ObservableList<ClientesDAO> Seleccionar(){

        ObservableList<ClientesDAO> listaC = FXCollections.observableArrayList();
        ClientesDAO objC;
        String query = "SELECT * FROM Clientes ORDER BY cveCliente";
        try {
            Statement stmt = Conexion.conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while( res.next() ){
                objC = new ClientesDAO();
                objC.setCveCliente(res.getInt("cveCliente"));
                objC.setNombreC(res.getString("nombreC"));
                objC.setTelC(res.getString("telC"));
                objC.setDireccionC(res.getString("direccionC"));
                listaC.add(objC);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaC;

    } //Recuperar todos los registros

    public void SeleccionarByID(){}
}
