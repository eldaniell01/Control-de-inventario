/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;
import entity.*;
import conexiondb.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class consult_category {
    public static ArrayList<category> getlistarea(){
        ArrayList<category> prov = new ArrayList<category>();
        conexion bd = new conexion();
        Connection cn = bd.getConnection();
        PreparedStatement inser = null;
        category pro = null;
        String insertarbd = "SELECT *FROM categoría";
        try{
            if(cn!=null){
                inser = cn.prepareStatement(insertarbd);
                ResultSet rs = inser.executeQuery();
                while(rs.next()){
                    pro = new category();    
                    pro.setId_category(Integer.parseInt(rs.getString(1)));
                    pro.setCategory(rs.getString(2));
                    if(prov.isEmpty()){
                        prov.add(0,pro);
                    }
                    else{
                        prov.add(pro);
                    }
                }
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error al buscar producto" + e);
            pro.setResult("error al buscar producto" + e);
        }finally{
            if(cn!=null){
                try{
                    cn.close();
                    inser.close();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);
                    pro.setResult("error "+e);
                }
                
            }
        }
        return prov;
        
    }
}
