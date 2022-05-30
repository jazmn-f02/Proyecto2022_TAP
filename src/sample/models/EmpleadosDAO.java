package sample.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpleadosDAO {

    private int cveEmpleado;
    private String nombreE;
    private String apellidoP;
    private String apellidoM;
    private String rfcE;
    private double sueldo;
    private  String telE;
    private  String nssE;
    private  String emailE;

    public int getCveEmpleado() {
        return cveEmpleado;
    }

    public void setCveEmpleado(int cveEmpleado) {
        this.cveEmpleado = cveEmpleado;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getRfcE() {
        return rfcE;
    }

    public void setRfcE(String rfcE) {
        this.rfcE = rfcE;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getTelE() {
        return telE;
    }

    public void setTelE(String telE) {
        this.telE = telE;
    }

    public String getNssE() {
        return nssE;
    }

    public void setNssE(String nssE) {
        this.nssE = nssE;
    }

    public String getEmailE() {
        return emailE;
    }

    public void setEmailE(String emailE) {
        this.emailE = emailE;
    }

    public void Insertar(){
        String query="INSERT INTO Empleados(nombreE, apellidoPatE, apellidoMatE, rfcE, sueldo, telE, nssE, emailE)"+
                "VALUES('"+this.nombreE+"','"+this.apellidoP+"','"+this.apellidoM+"','"+this.rfcE+"','"+this.sueldo+
                "','"+this.telE+"','"+this.nssE+"','"+this.emailE+"'";

        try {
            Statement stmt=Conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Actualizar(){
        String query="UPDATE Empleados SET nombreE='"+this.nombreE+"', apellidoPatE='"+this.apellidoP+"'," +
                "apellidoMatE='"+this.apellidoM+"', rfcE='"+this.rfcE+"', sueldo='"+this.sueldo+"', telE='"+
                this.telE+"', nssE='"+this.nssE+"', emailE='"+this.emailE+"' WHERE cveEmpleado="+this.cveEmpleado;

        try {
            Statement stmt=Conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void Eliminar(){
        String query="DELETE FROM Empleados WHERE cveEmpleado="+this.cveEmpleado;

        try {
            Statement stmt=Conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<EmpleadosDAO> Seleccionar(){

        ObservableList<EmpleadosDAO> listaE= FXCollections.observableArrayList();
        EmpleadosDAO objE;
        String query="SELECT * FROM Empleados ORDER BY cveEmpleado";

        try {
            Statement stmt=Conexion.conexion.createStatement();
            ResultSet res=stmt.executeQuery(query);
            while (res.next()){
                objE=new EmpleadosDAO();
                objE.setCveEmpleado(res.getInt("cveEmpleado"));
                objE.setNombreE(res.getString("nombreE"));
                objE.setApellidoP(res.getString("apellidoPatE"));
                objE.setApellidoM(res.getString("apellidoMatE"));
                objE.setRfcE(res.getString("rfcE"));
                objE.setSueldo(res.getDouble("sueldo"));
                objE.setTelE(res.getString("telE"));
                objE.setNssE(res.getString("nssE"));
                objE.setEmailE(res.getString("emailE"));
                listaE.add(objE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaE;
    }
}
