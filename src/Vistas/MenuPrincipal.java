package Vistas;

public class MenuPrincipal extends javax.swing.JFrame {

    public MenuPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemAgregarCliente = new javax.swing.JMenuItem();
        itemModificarCliente = new javax.swing.JMenuItem();
        MenuProveedor = new javax.swing.JMenu();
        itemRegistrarProv = new javax.swing.JMenuItem();
        itemModificarP = new javax.swing.JMenuItem();
        itemRegistro = new javax.swing.JMenu();
        itemRegistrar = new javax.swing.JMenuItem();
        itemRegistroLista = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itemRegistrarCompra = new javax.swing.JMenuItem();
        itemRegistroCompras = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuRegistrar = new javax.swing.JMenuItem();
        itemInventario = new javax.swing.JMenuItem();

        jMenu4.setText("jMenu4");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(255, 230, 0));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 764, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 443, Short.MAX_VALUE)
        );

        jMenu1.setText("Cliente");

        itemAgregarCliente.setText("Agregar Clientes");
        itemAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAgregarClienteActionPerformed(evt);
            }
        });
        jMenu1.add(itemAgregarCliente);

        itemModificarCliente.setText("Modificar Clientes");
        itemModificarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemModificarClienteActionPerformed(evt);
            }
        });
        jMenu1.add(itemModificarCliente);

        jMenuBar1.add(jMenu1);

        MenuProveedor.setText("Proveedor");
        MenuProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuProveedorActionPerformed(evt);
            }
        });

        itemRegistrarProv.setText("Registrar Proveedor");
        itemRegistrarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRegistrarProvActionPerformed(evt);
            }
        });
        MenuProveedor.add(itemRegistrarProv);

        itemModificarP.setText("Modificar Proveedores");
        itemModificarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemModificarPActionPerformed(evt);
            }
        });
        MenuProveedor.add(itemModificarP);

        jMenuBar1.add(MenuProveedor);

        itemRegistro.setText("Venta");
        itemRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRegistroActionPerformed(evt);
            }
        });

        itemRegistrar.setText("Registrar");
        itemRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRegistrarActionPerformed(evt);
            }
        });
        itemRegistro.add(itemRegistrar);

        itemRegistroLista.setText("Registro de Ventas");
        itemRegistroLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRegistroListaActionPerformed(evt);
            }
        });
        itemRegistro.add(itemRegistroLista);

        jMenuBar1.add(itemRegistro);

        jMenu2.setText("Compra");

        itemRegistrarCompra.setText("Registrar");
        itemRegistrarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRegistrarCompraActionPerformed(evt);
            }
        });
        jMenu2.add(itemRegistrarCompra);

        itemRegistroCompras.setText("Registro de Compras");
        itemRegistroCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRegistroComprasActionPerformed(evt);
            }
        });
        jMenu2.add(itemRegistroCompras);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Producto");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        menuRegistrar.setText("Registrar");
        menuRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRegistrarActionPerformed(evt);
            }
        });
        jMenu3.add(menuRegistrar);

        itemInventario.setText("Inventario");
        itemInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemInventarioActionPerformed(evt);
            }
        });
        jMenu3.add(itemInventario);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //vista alumno    
    private void itemModificarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemModificarClienteActionPerformed
        escritorio.removeAll(); //remover todo
        escritorio.repaint(); //redibujar     

        VistaModificarClientes vcl = new VistaModificarClientes();   //creamos la vista cliente
        vcl.setVisible(true); //hacemos visible esa vista

        //agregamos y la llevamos al frente del escritorio
        escritorio.add(vcl);
        escritorio.moveToFront(vcl);
    }//GEN-LAST:event_itemModificarClienteActionPerformed


    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void itemAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAgregarClienteActionPerformed
        escritorio.removeAll(); //remover todo
        escritorio.repaint(); //redibujar     

        VistaAgregClientes vcl2 = new VistaAgregClientes();   //creamos la vista cliente
        vcl2.setVisible(true); //hacemos visible esa vista

        //agregamos y la llevamos al frente del escritorio
        escritorio.add(vcl2);
        escritorio.moveToFront(vcl2);
    }//GEN-LAST:event_itemAgregarClienteActionPerformed

    private void MenuProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuProveedorActionPerformed

    private void itemRegistrarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRegistrarProvActionPerformed
        escritorio.removeAll(); //remover todo
        escritorio.repaint(); //redibujar     

        VistaRegistrarProveedor vP = new   VistaRegistrarProveedor ();   //creamos la vista cliente
        vP.setVisible(true); //hacemos visible esa vista

        //agregamos y la llevamos al frente del escritorio
        escritorio.add(vP);
        escritorio.moveToFront(vP);
    }//GEN-LAST:event_itemRegistrarProvActionPerformed

    private void menuRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRegistrarActionPerformed
        escritorio.removeAll(); //remover todo
        escritorio.repaint(); //redibujar     

        VistaRegistrarProducto rP = new   VistaRegistrarProducto();   //creamos la vista cliente
        rP.setVisible(true); //hacemos visible esa vista

        //agregamos y la llevamos al frente del escritorio
        escritorio.add(rP);
        escritorio.moveToFront(rP);
    }//GEN-LAST:event_menuRegistrarActionPerformed

    private void itemInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemInventarioActionPerformed
        escritorio.removeAll(); //remover todo
        escritorio.repaint(); //redibujar     

        VistaListaProductos lP = new   VistaListaProductos();   //creamos la vista cliente
        lP.setVisible(true); //hacemos visible esa vista

        //agregamos y la llevamos al frente del escritorio
        escritorio.add(lP);
        escritorio.moveToFront(lP);
    }//GEN-LAST:event_itemInventarioActionPerformed

    private void itemRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRegistroActionPerformed
        escritorio.removeAll(); //remover todo
        escritorio.repaint(); //redibujar     

        VistaListaVentas lV = new   VistaListaVentas();   //creamos la vista cliente
        lV.setVisible(true); //hacemos visible esa vista

        //agregamos y la llevamos al frente del escritorio
        escritorio.add(lV);
        escritorio.moveToFront(lV);
    }//GEN-LAST:event_itemRegistroActionPerformed

    private void itemRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRegistrarActionPerformed
       
        escritorio.removeAll(); //remover todo
        escritorio.repaint(); //redibujar     

        VistaVentas vV = new VistaVentas();   //creamos la vista cliente
        vV.setVisible(true); //hacemos visible esa vista

        //agregamos y la llevamos al frente del escritorio
        escritorio.add(vV);
        escritorio.moveToFront(vV);
    }//GEN-LAST:event_itemRegistrarActionPerformed

    private void itemRegistroListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRegistroListaActionPerformed
         escritorio.removeAll(); //remover todo
        escritorio.repaint(); //redibujar     

        VistaListaVentas lV = new   VistaListaVentas();   //creamos la vista cliente
        lV.setVisible(true); //hacemos visible esa vista

        //agregamos y la llevamos al frente del escritorio
        escritorio.add(lV);
        escritorio.moveToFront(lV);
    }//GEN-LAST:event_itemRegistroListaActionPerformed

    private void itemRegistrarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRegistrarCompraActionPerformed
        escritorio.removeAll(); //remover todo
        escritorio.repaint(); //redibujar     

        VistaCompras vC = new   VistaCompras();   //creamos la vista cliente
        vC.setVisible(true); //hacemos visible esa vista

        //agregamos y la llevamos al frente del escritorio
        escritorio.add(vC);
        escritorio.moveToFront(vC);
    }//GEN-LAST:event_itemRegistrarCompraActionPerformed

    private void itemRegistroComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRegistroComprasActionPerformed
        escritorio.removeAll(); //remover todo
        escritorio.repaint(); //redibujar     

        VistaListaCompras vlC = new   VistaListaCompras();   //creamos la vista cliente
        vlC.setVisible(true); //hacemos visible esa vista

        //agregamos y la llevamos al frente del escritorio
        escritorio.add(vlC);
        escritorio.moveToFront(vlC);
    }//GEN-LAST:event_itemRegistroComprasActionPerformed

    private void itemModificarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemModificarPActionPerformed
            escritorio.removeAll(); //remover todo
        escritorio.repaint(); //redibujar     

        VistaModificarProveedor vMP = new   VistaModificarProveedor();   //creamos la vista cliente
        vMP.setVisible(true); //hacemos visible esa vista

        //agregamos y la llevamos al frente del escritorio
        escritorio.add(vMP);
        escritorio.moveToFront(vMP);
    }//GEN-LAST:event_itemModificarPActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuProveedor;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem itemAgregarCliente;
    private javax.swing.JMenuItem itemInventario;
    private javax.swing.JMenuItem itemModificarCliente;
    private javax.swing.JMenuItem itemModificarP;
    private javax.swing.JMenuItem itemRegistrar;
    private javax.swing.JMenuItem itemRegistrarCompra;
    private javax.swing.JMenuItem itemRegistrarProv;
    private javax.swing.JMenu itemRegistro;
    private javax.swing.JMenuItem itemRegistroCompras;
    private javax.swing.JMenuItem itemRegistroLista;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem menuRegistrar;
    // End of variables declaration//GEN-END:variables
}
