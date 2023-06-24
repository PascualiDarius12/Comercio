package ClasesData;

import Modelo.Cliente;
import Modelo.DetalleCompra;
import Modelo.DetalleVenta;
import Modelo.Producto;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProductoData {

    private Connection con = null;

    public ProductoData() {

        con = Conexion.getConexion();

    }

    public void registrarProducto(Producto pr) {

        String sql = "INSERT INTO producto( precioActual, stock, estado, nombre, categoria, descripcion) VALUES (?,?,?,?,?,?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setDouble(1, pr.getPrecioActual());
            ps.setInt(2, pr.getStock());
            ps.setBoolean(3, true);
            ps.setString(4, pr.getNombre());
            ps.setString(5, pr.getCategoria());
            ps.setString(6, pr.getDescripcion());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pr.setIdProducto(rs.getInt("idProducto"));
                JOptionPane.showMessageDialog(null, "Producto añadido con exito.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto" + ex.getMessage());
        }

    }

    public List<Producto> listarProductos() {

        List<Producto> productos = new ArrayList<>();

        try {

            String sql = "SELECT * FROM producto";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto pr = new Producto();

                pr.setIdProducto(rs.getInt("idProducto"));
                pr.setNombre(rs.getString("nombre"));
                pr.setCategoria(rs.getString("categoria"));
                pr.setDescripcion(rs.getString("descripcion"));
                pr.setPrecioActual(rs.getDouble("precioActual"));
                pr.setStock(rs.getInt("stock"));
                pr.setEstado(rs.getBoolean("estado"));

                productos.add(pr);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Producto " + ex.getMessage());
        }
        return productos;
    }
    
    public List<Producto> listarProductosPorSubCadena(String subCadena) {

        List<Producto> productos = new ArrayList<>();

        try {

            String sql = "SELECT * FROM producto WHERE nombre LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,  subCadena + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto pr = new Producto();

                pr.setIdProducto(rs.getInt("idProducto"));
                pr.setNombre(rs.getString("nombre"));
                pr.setCategoria(rs.getString("categoria"));
                pr.setDescripcion(rs.getString("descripcion"));
                pr.setPrecioActual(rs.getDouble("precioActual"));
                pr.setStock(rs.getInt("stock"));
                pr.setEstado(rs.getBoolean("estado"));

                productos.add(pr);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Producto " + ex.getMessage());
        }
        return productos;
    }
    
    
    
    

    public Producto buscarProducto(String nombre) {
        Producto p = null; //   Alumno alumno = null;
        String sql = "SELECT * FROM producto WHERE nombre=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);

            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                p = new Producto();
                p.setIdProducto(rs.getInt("idProducto"));
                p.setNombre(rs.getString("nombre"));
                p.setCategoria(rs.getString("categoria"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecioActual(rs.getDouble("precioActual"));
                p.setStock(rs.getInt("stock"));
                p.setEstado(rs.getBoolean("estado"));
            }

            ps.close();
            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto" + ex.getMessage());
        }

        return p;
    }
    
    public Producto buscarProductoPorSubCadena(String nombre) {
        Producto p = null; //   Alumno alumno = null;
        String sql = "SELECT * FROM producto WHERE nombre LIKE '%?%'";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);

            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                p = new Producto();
                p.setIdProducto(rs.getInt("idProducto"));
                p.setNombre(rs.getString("nombre"));
                p.setCategoria(rs.getString("categoria"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecioActual(rs.getDouble("precioActual"));
                p.setStock(rs.getInt("stock"));
                p.setEstado(rs.getBoolean("estado"));
            }

            ps.close();
            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto" + ex.getMessage());
        }

        return p;
    }
    public Producto buscarProductoPorID (int idProducto){
        Producto p = null;
        String sql = "SELECT * FROM producto WHERE idProducto=?";
            
           try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProducto);

            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                p = new Producto();
                p.setIdProducto(rs.getInt("idProducto"));
                p.setNombre(rs.getString("nombre"));
                p.setCategoria(rs.getString("categoria"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecioActual(rs.getDouble("precioActual"));
                p.setStock(rs.getInt("stock"));
                p.setEstado(rs.getBoolean("estado"));
            }

            ps.close();
            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto" + ex.getMessage());
        }

        return p;
    }

     public void eliminarProducto(int id) {
         String sql = "UPDATE producto SET estado=? WHERE idProducto=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

           
            ps.setBoolean(1, false);
            ps.setInt(2, id);
            

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "El Producto se elimino correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el Producto");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto" + ex.getMessage());
        }
    }
    
     
    
    public void incrementarStock(int idProducto, DetalleCompra compra, int stock) {
        String sql = "UPDATE producto SET stock= ?  WHERE producto.idProducto = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, stock + compra.getCantidad());
            ps.setInt(2, idProducto);

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "El stock se actualizo correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar el stock");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto");
        }

    }

    public void decrementarStock(int idProducto, DetalleVenta venta, int stock) {
        String sql = "UPDATE producto SET stock= ?  WHERE producto.idProducto = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, stock - venta.getCantidad());
            ps.setInt(2, idProducto);

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "El stock se actualizo correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar el stock");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto");
        }

    }
    
    public void modificarProducto(Producto p){
         String sql = "UPDATE producto SET nombre=? , descripcion=? , categoria=? , precioActual=?, stock=?, estado=? WHERE idProducto=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDescripcion());
            ps.setString(3, p.getCategoria());
            ps.setDouble(4, p.getPrecioActual());
            ps.setInt(5, p.getStock());
            ps.setBoolean(6, p.isEstado());
            ps.setInt(7, p.getIdProducto());

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "El Producto se actualizo correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar el Producto");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto" + ex.getMessage());
        }
    }

}
