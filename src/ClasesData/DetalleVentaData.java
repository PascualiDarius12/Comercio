/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesData;

import Modelo.DetalleVenta;
import Modelo.Producto;
import Modelo.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author wilgortiz
 */
public class DetalleVentaData {
    
    private Connection con = null;
    private ProductoData pData;
    private VentaData vData;

    public DetalleVentaData() {

        con = Conexion.getConexion();
        
        pData = new ProductoData();
        vData = new VentaData();
        
        
    }
    
    public void registrarDetalleVenta(DetalleVenta detalle, int idVenta, int idProducto){ //cree en productoData un metodo modificar producto, para que cuando compremos o vendamos ese producto se modifique stock
        String sql = "INSERT INTO detalleventa(cantidad, precioVenta, idVenta, idProducto) VALUES (?,?,?,?);";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, detalle.getCantidad());
            ps.setDouble(2, detalle.getPrecioVenta());
            ps.setInt(3, idVenta);
            ps.setInt(4, idProducto);
            
            int aux = ps.executeUpdate();
            
            if(aux == 1){
                JOptionPane.showMessageDialog(null, "Detalle de la venta registrado");
            }else{
                JOptionPane.showMessageDialog(null, "Fallo al registar el detalle de la venta");
            }
            
            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla detalle de venta" + ex.getMessage());
        }
        
        
    }
    public DetalleVenta buscarDetalle(int idVenta){
        
      DetalleVenta detV = null;
        
        String sql = "SELECT idDetalleVenta, cantidad, precioVenta, idVenta, idProducto FROM detalleventa WHERE idVenta =?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idVenta);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                detV = new DetalleVenta();
                
                detV.setIdDetalleVenta(rs.getInt("idDetalleVenta"));
                detV.setCantidad(rs.getInt("cantidad"));
                detV.setPrecioVenta(rs.getInt("precioVenta"));
                detV.setVenta(vData.buscarVentaPorID(rs.getInt("idVenta")));
                detV.setProducto(pData.buscarProductoPorID(rs.getInt("idProducto")));
                
                
            }
            
            ps.close();
            rs.close();
            
            
        } catch (SQLException ex) {
            
        }
       return detV;
    }

}


//int idDetalleVenta, int cantidad, double precioVenta, Venta venta, Producto producto