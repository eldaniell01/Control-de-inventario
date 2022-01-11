/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexiondb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author danie
 */
public class conexion {
    private PreparedStatement psinsertar;
    private Connection co; // variable de tipo conexion
    private Statement stm;
    public conexion(){
        co = null; // se anula la conexion
        try {
            String url = "jdbc:mysql://localhost:3306/mydb"; // direccion de la base de datos 
            String usuario = "root"; // usuario para la base de datos 
            String pass = "12Intercambios"; // contraseña de la base de datos 
            Class.forName("com.mysql.jdbc.Driver"); // conecta la libreria 
            co = DriverManager.getConnection(url, usuario, pass); // obtiene la coneccion 
            if(co!=null){
                
                System.out.println("conexion establecida");
            }
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e+" error en la conexion1");
        }
    }
    public Connection getConnection(){
        return co;
    }
    
    public void desconectar(){
        co = null;
        if (co==null){
            System.out.print("conexion terminada");
        }
    }
}
