/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesData;

import Modelo.Cliente;
import Modelo.Venta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author wilgortiz
 */
public class VentaData {
   
     private Connection con = null;

    public VentaData() {

        con = Conexion.getConexion();

    }
    
    public int registrarVenta(Venta venta, int idCliente){
        String sql = "INSERT INTO venta(fecha, idCliente) VALUES (?,?);";
        
         try {
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ps.setDate(1, Date.valueOf(venta.getFecha()));
             ps.setInt(2, idCliente);
             
             ps.executeUpdate();
             
             ResultSet rs = ps.getGeneratedKeys();
             
             while (rs.next()) {
                 venta.setIdVenta(rs.getInt("isVenta"));
                 JOptionPane.showMessageDialog(null, "Venta registrada");
                 
             }
             
             rs.close();
             ps.close();
             
             
             
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al acceder a la tabla venta" + ex.getMessage());
         }
         
         return venta.getIdVenta();
    }
    
    
    public List<Venta> listaVentas(){
        
        List<Venta> listaDeVentas = new ArrayList<>();
        
        String sql = "SELECT * FROM venta";
         try {
             PreparedStatement ps = con.prepareStatement(sql);
             
             ResultSet rs = ps.executeQuery();
             
             while (rs.next()) {
               Venta v = new Venta();
               Cliente c = new Cliente();
               c.setIdCliente(rs.getInt("idCliente"));
               
               
               v.setIdVenta(rs.getInt("idVenta"));
               v.setFecha(rs.getDate("fecha").toLocalDate());
               v.setCliente(c);
               
               listaDeVentas.add(v);
             }
             
             
         } catch (SQLException ex) {
            
         }
        
         return listaDeVentas;
    } 
    
   
    
    public Venta buscarVentaPorID (int idVenta){
        Venta v = null;
        String sql = "SELECT * FROM Venta WHERE idVenta=?";
            
           try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idVenta);

            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                v = new Venta();
                ClienteData cD= new ClienteData();
               
                v.setIdVenta(rs.getInt("idVenta"));
                v.setCliente(cD.buscarCliente(rs.getInt("idCliente")));
               
            }

            ps.close();
            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Venta" + ex.getMessage());
        }
    
    return v;
    }
    
    
    
    
}
