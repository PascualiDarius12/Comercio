/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesData;

import Modelo.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author 54266
 */
public class CompraData {

    private Connection con = null;
    private ProveedorData proveData;

    public CompraData() {

        con = Conexion.getConexion();
        proveData = new ProveedorData();

    }

    public int registrarCompra(Compra compra, int idProveedor) {

        String sql = " INSERT INTO compra (idProveedor, fecha) VALUES (?,?) ";
        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idProveedor);
            ps.setDate(2, Date.valueOf(compra.getFecha()));

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            while (rs.next()) {
                compra.setIdCompra(rs.getInt("idCompra"));
                JOptionPane.showMessageDialog(null, "Compra generada");
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Compra"+ ex.getMessage());

        }
       return compra.getIdCompra();
    }
    
    public Compra buscarCompraPorID (int idCompra){
        Compra c = null;
        String sql = "SELECT * FROM Compra WHERE idCompra=?";
            
           try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCompra);

            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                c = new Compra();
                ClienteData cD= new ClienteData();
               
                c.setIdCompra(rs.getInt("idCompra"));
                c.setProveedorC(proveData.buscarProveedorPorID(rs.getInt("idProveedor"))); //buscar proveedor
               
            }

            ps.close();
            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Compra" + ex.getMessage());
        }
    
    return c;
    }
    
    
    
    
    public List<Compra> listaCompras(){
        
        List<Compra> listaDeCompras = new ArrayList<>();
        
        String sql = "SELECT * FROM compra";
         try {
             PreparedStatement ps = con.prepareStatement(sql);
             
             ResultSet rs = ps.executeQuery();
             
             while (rs.next()) {
               Compra com = new Compra();
               Proveedor p = new Proveedor();
               p.setIdProveedor(rs.getInt("idProveedor"));
               
               
               com.setIdCompra(rs.getInt("idCompra"));
               com.setFecha(rs.getDate("fecha").toLocalDate());
               com.setProveedorC(p);
               
               listaDeCompras.add(com);
             }
             
             ps.close();
             rs.close();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Compra" + ex.getMessage());
         }
        
         return listaDeCompras;
    }
}
