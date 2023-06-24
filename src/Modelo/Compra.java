
package Modelo;

import java.time.LocalDate;


public class Compra {
    private int idCompra;
    private Proveedor proveedorC;
    private LocalDate fecha;

    public Compra() {
    }


    public Compra(Proveedor proveedorC, LocalDate fecha) {
        this.proveedorC = proveedorC;
        this.fecha = fecha;
    }

    public Compra(int idCompra, Proveedor proveedorC, LocalDate fecha) {
        this.idCompra = idCompra;
        this.proveedorC = proveedorC;
        this.fecha = fecha;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Proveedor getProveedorC() {
        return proveedorC;
    }

    public void setProveedorC(Proveedor proveedorC) {
        this.proveedorC = proveedorC;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Compra{" + "idCompra=" + idCompra + ", proveedorC=" + proveedorC + ", fecha=" + fecha + '}';
    }
    
    
    
    
}
