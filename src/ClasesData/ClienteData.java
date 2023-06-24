package ClasesData;

import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteData {

    private Connection con = null;

    public ClienteData() {

        con = Conexion.getConexion();

    }

    public Cliente buscarCliente(int id) {

        Cliente cliente = null;
        String sql = "SELECT  * FROM cliente WHERE idCliente=? ";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setDomicilio(rs.getString("domicilio"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEstado(rs.getBoolean("estado"));

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno " + ex.getMessage());
        }

        return cliente;
    }

    public Cliente buscarClientePorNombre(String nombre) {
        Cliente cliente = null;
        String sql = "SELECT * FROM cliente WHERE nombre=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setDomicilio(rs.getString("domicilio"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEstado(rs.getBoolean("estado"));
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Cliente: " + ex.getMessage());
        }

        return cliente;
    }

    public void agregarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (apellido, nombre, domicilio, telefono, estado) VALUES (?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, cliente.getApellido());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getDomicilio());
            ps.setString(4, cliente.getTelefono());
            ps.setBoolean(5, true);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                cliente.setIdCliente(rs.getInt("idCliente"));

                JOptionPane.showMessageDialog(null, "Cliente agregado con exito");
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Cliente" + ex.getMessage());

        }
    }

    //VER
    public void eliminarCliente(int id) {
         String sql = "UPDATE cliente SET estado=? WHERE idCliente=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setBoolean(1, false);
            ps.setInt(2, id);
           

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "El cliente se elimino correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el cliente");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente" + ex.getMessage());
        }
    }

    public void modificarCliente(Cliente nuevoCliente, int idCliente) {
        String sql = "UPDATE cliente SET apellido=? , nombre=? , domicilio=? , telefono=?, estado=? WHERE idCliente=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nuevoCliente.getApellido());
            ps.setString(2, nuevoCliente.getNombre());
            ps.setString(3, nuevoCliente.getDomicilio());
            ps.setString(4, nuevoCliente.getTelefono());
            ps.setBoolean(5, nuevoCliente.isEstado());
            ps.setInt(6, idCliente);

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "El cliente se actualizo correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar el cliente");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente" + ex.getMessage());
        }

    }

    public List<Cliente> listarClientesPorSubCadena(String subCadena) {

        List<Cliente> clientes = new ArrayList<>();

        try {

            String sql = "SELECT * FROM Cliente WHERE nombre LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, subCadena + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();

                c.setIdCliente(rs.getInt("idCliente"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setDomicilio(rs.getString("domicilio"));
                c.setTelefono(rs.getString("telefono"));
                c.setEstado(rs.getBoolean("estado"));

                clientes.add(c);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Producto " + ex.getMessage());
        }
        return clientes;
    }

    public List<Cliente> listarClientes() {

        List<Cliente> clientes = new ArrayList<>();

        try {

            String sql = "SELECT * FROM cliente";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();

                c.setIdCliente(rs.getInt("idCliente"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setTelefono(rs.getString("telefono"));
                c.setDomicilio(rs.getString("domicilio"));
                c.setEstado(rs.getBoolean("estado"));
                

                clientes.add(c);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Clientes " + ex.getMessage());
        }
        return clientes;
    }

//    //HICE ESTA NUEVA, CON UN SOLO PARAMETRO.
//    public void modificarCliente(Cliente nuevoCliente) {
//    String sql = "UPDATE cliente SET apellido=?, nombre=?, domicilio=?, telefono=? ";
//
//    try {
//        PreparedStatement ps = con.prepareStatement(sql);
//
//        ps.setString(1, nuevoCliente.getApellido());
//        ps.setString(2, nuevoCliente.getNombre());
//        ps.setString(3, nuevoCliente.getDomicilio());
//        ps.setString(4, nuevoCliente.getTelefono());
//
//        int exito = ps.executeUpdate();
//
//        if (exito == 1) {
//            JOptionPane.showMessageDialog(null, "El cliente se actualizó correctamente");
//        } else {
//            JOptionPane.showMessageDialog(null, "Error al actualizar el cliente");
//        }
//
//        ps.close();
//
//    } catch (SQLException ex) {
//        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente: " + ex.getMessage());
//    }
}
