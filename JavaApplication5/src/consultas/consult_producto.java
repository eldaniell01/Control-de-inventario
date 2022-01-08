/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;
import java.sql.*;
import entity.*;
import conexiondb.conexion;
import javax.swing.JOptionPane;
/**
 *
 * @author danie
 */
public class consult_producto {
    public static String reg_producto(Producto p){
        String r = null;
        conexion bd = new conexion();
        Connection cn = bd.getConnection();
        PreparedStatement inser = null;
        String insertarbd = "INSERT INTO producto values(null, ?, ?, ?, ?, ?)";
        try{
            inser = cn.prepareStatement(insertarbd);
            inser.setString(1, p.getName());
            inser.setString(2, p.getMarca());
            inser.setFloat(3, p.getPv());
            inser.setInt(4, p.getExistencia());
            inser.setInt(5, p.getCategory());
            inser.executeUpdate();
            JOptionPane.showMessageDialog(null, "producto registrado" + inser);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error al agregar producto" + e);
        }
        finally{
            if(cn!=null){
                try{
                    cn.close();
                    inser.close();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }
                
            }
        }
        return r;
    }
}
