/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import ClasesData.*;
import Modelo.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mateo
 */
public class VistaListaCompras extends javax.swing.JInternalFrame {

    private List<Compra> compras;
    private CompraData comData;
    private DetalleCompra dCompra;
    private Compra compra;
    private DefaultTableModel modelo;
    private ProveedorData provD;
    private ProductoData pD;
    private DetalleCompraData dC;

    public VistaListaCompras() {
        initComponents();
        compra = new Compra();
        comData = new CompraData();
        compras = new ArrayList<>();
        modelo = new DefaultTableModel();
        dCompra = new DetalleCompra();
        provD = new ProveedorData();
        pD = new ProductoData();
        dC = new DetalleCompraData();

        CrearTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDayChooser1 = new com.toedter.calendar.JDayChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        calendario = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCompras = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        checkTodas = new javax.swing.JCheckBox();
        btnSalir = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 230, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("Registro de Compras");

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("Filtrar por Fecha:");

        calendario.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calendarioPropertyChange(evt);
            }
        });

        tablaCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaCompras);

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
        jLabel3.setText("Fravemax");

        checkTodas.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 16)); // NOI18N
        checkTodas.setForeground(new java.awt.Color(0, 51, 102));
        checkTodas.setText("Mostrar Todo");
        checkTodas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkTodasItemStateChanged(evt);
            }
        });
        checkTodas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                checkTodasStateChanged(evt);
            }
        });
        checkTodas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                checkTodasMouseReleased(evt);
            }
        });
        checkTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkTodasActionPerformed(evt);
            }
        });
        checkTodas.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                checkTodasPropertyChange(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 0, 0));
        btnSalir.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("X");
        btnSalir.setBorder(null);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 289, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(370, 370, 370))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkTodas, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(265, 265, 265))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(btnSalir))
                .addGap(4, 4, 4)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(checkTodas, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkTodasPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_checkTodasPropertyChange

    }//GEN-LAST:event_checkTodasPropertyChange

    private void checkTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkTodasActionPerformed
        limpiarTabla();
        if (checkTodas.isSelected()) {
            CargarTabla();
        }
    }//GEN-LAST:event_checkTodasActionPerformed

    private void checkTodasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkTodasMouseReleased

    }//GEN-LAST:event_checkTodasMouseReleased

    private void checkTodasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_checkTodasStateChanged

    }//GEN-LAST:event_checkTodasStateChanged

    private void checkTodasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkTodasItemStateChanged

    }//GEN-LAST:event_checkTodasItemStateChanged

    private void calendarioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calendarioPropertyChange
        limpiarTabla();
        compras = comData.listaCompras();
        // Obtener el valor seleccionado como objeto Calendar
        Calendar calendar = calendario.getCalendar();

        // Convertir el objeto Calendar a LocalDate
        try {
            LocalDate fecha = calendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            for (Compra aux : compras) {

                if (aux.getFecha().compareTo(fecha) == 0) {
                    Proveedor p1 = provD.buscarProveedorPorID(aux.getProveedorC().getIdProveedor());

                    DetalleCompra dC1 = dC.buscarDetalleCompra(aux.getIdCompra());

                    modelo.addRow(new Object[]{aux.getIdCompra(), aux.getFecha(), p1.getNombre(), p1.getRazonSocial(), p1.getTelefono(), p1.getDomicilio(), dC1.getProducto().getNombre(), dC1.getCantidad(), dC1.getPrecioCosto()});
                }

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_calendarioPropertyChange

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirActionPerformed

    private void CrearTabla() {

        //para cargar los datos de inscripcion a la tabla
        //columnas:
        ArrayList<Object> columnas = new ArrayList<Object>();
        columnas.add("ID");
        columnas.add("Fecha");
        columnas.add("Nombre");
        columnas.add("Razon Social");
        columnas.add("Telefono");
        columnas.add("Domicilio");
        columnas.add("Producto");
        columnas.add("Cantidad");
        columnas.add("Precio");
        
        modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            
            return column != 0 && column != 1 && column != 2 && column != 3 && column != 4 && column != 5 && column != 6 && column != 7 && column != 8; 
        }
    };


        for (Object columna : columnas) {
            modelo.addColumn(columna);   //para agregarle columna x columna recorremos con un for each la lista columnas
        }
        tablaCompras.setModel(modelo); //le setemos por ultimo el modelo a la tabla

        limpiarTabla();

    }

    private void CargarTabla() {

        compras = comData.listaCompras();

        for (Compra aux : compras) {

            Proveedor p1 = provD.buscarProveedorPorID(aux.getProveedorC().getIdProveedor());

            DetalleCompra dC1 = dC.buscarDetalleCompra(aux.getIdCompra());

            modelo.addRow(new Object[]{aux.getIdCompra(), aux.getFecha(), p1.getNombre(), p1.getRazonSocial(), p1.getTelefono(), p1.getDomicilio(), dC1.getProducto().getNombre(), dC1.getCantidad(), dC1.getPrecioCosto()});
        }
    }

    private void limpiarTabla() {
        int filas = modelo.getRowCount() - 1; //saber cantidad de filas

        for (int i = filas; i >= 0; i--) {   //recorre para borralas una x una
            modelo.removeRow(i);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private com.toedter.calendar.JDateChooser calendario;
    private javax.swing.JCheckBox checkTodas;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDayChooser jDayChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCompras;
    // End of variables declaration//GEN-END:variables
}
