/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesData;

import Modelo.DetalleCompra;
import Modelo.DetalleVenta;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author wilgortiz
 */
public class DetalleCompraData {
    
     private Connection con = null;
    
     private CompraData cData;
     private ProductoData pData;
     

    public DetalleCompraData() {

        con = Conexion.getConexion();
       
        cData = new CompraData();
        pData = new ProductoData();

    }
    
    public void registrarDetalleCompra( DetalleCompra detalle, int idCompra, int idProducto){ //cree en productoData un metodo modificar producto, para que cuando compremos o vendamos ese producto se modifique stock
        String sql = "INSERT INTO detallecompra(cantidad, precioCosto, idCompra, idProducto) VALUES (?,?,?,?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, detalle.getCantidad());
            ps.setDouble(2, detalle.getPrecioCosto());
            ps.setInt(3, idCompra);
            ps.setInt(4, idProducto);
            
            int aux = ps.executeUpdate();
            
            if(aux == 1){
                JOptionPane.showMessageDialog(null, "Detalle de la compra registrado");
            }else{
                JOptionPane.showMessageDialog(null, "Fallo al registar el detalle de la compra");
            }
            
            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla detalle de compra" + ex.getMessage());
        }
        
        
    }
    
     public DetalleCompra buscarDetalleCompra(int idCompra){
        
      DetalleCompra detC = null;
        
        String sql = "SELECT * FROM detallecompra WHERE idCompra =?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCompra);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                detC = new DetalleCompra();
                
                detC.setIdDetalleCompra(rs.getInt("idDetalle"));
                detC.setCantidad(rs.getInt("cantidad"));
                detC.setPrecioCosto(rs.getInt("precioCosto"));
                detC.setCompra(cData.buscarCompraPorID(rs.getInt("idCompra")));
                detC.setProducto(pData.buscarProductoPorID(rs.getInt("idProducto")));
                
                
            }
            
            ps.close();
            rs.close();
            
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla detalle de compra" + ex.getMessage());
        }
       return detC;
    }


}
