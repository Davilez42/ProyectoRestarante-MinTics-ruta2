/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.utp.corrientazo.vista.gui;

import com.edu.utp.corrientazo.controlador.RestauranteController;
import com.edu.utp.corrientazo.exception.PagoExcepcion;
import com.edu.utp.corrientazo.modelo.Corrientazo;
import com.edu.utp.corrientazo.modelo.Mesa;
import com.edu.utp.corrientazo.modelo.OpcionCarne;
import com.edu.utp.corrientazo.modelo.OpcionEnsalada;
import com.edu.utp.corrientazo.modelo.OpcionJugo;
import com.edu.utp.corrientazo.modelo.OpcionPrincipio;
import com.edu.utp.corrientazo.modelo.OpcionSopa;
import com.edu.utp.corrientazo.modelo.Pedido;
import com.edu.utp.corrientazo.vista.gui.modelogui.PedidoTable;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SingleSelectionModel;

/**
 *
 * @author joses
 */
public class RestauranteGUI extends javax.swing.JFrame {

    //controlller
    private RestauranteController controlador;
    
    public RestauranteGUI() {
        initComponents();
        setSize(1000, 600);
        setLocationRelativeTo(null);
        controlador = new RestauranteController();
        cargarListaDeMesas();
        cargarOpcionesComida();
        tablaPedidos.setModel(new PedidoTable());
        tablaPedidos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaPedidos.getSelectionModel().addListSelectionListener(avt -> mostrarInformacionDelPedido());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        nuevoPedido = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        totalPagar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        efectivo = new javax.swing.JSpinner();
        btonPagar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        devuelta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaMesas = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        botonEntregar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        clienteNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbSopas = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cmbPrincipio = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cmbCarne = new javax.swing.JComboBox<>();
        chkEnsalada = new javax.swing.JCheckBox();
        cmbEnsaldada = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmbJugo = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        guardarPedido = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Restaurante");
        getContentPane().setLayout(new java.awt.GridLayout(1, 3));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mesas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel1.setLayout(new java.awt.BorderLayout());

        nuevoPedido.setText("Nuevo Pedido");
        nuevoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoPedidoActionPerformed(evt);
            }
        });
        jPanel4.add(nuevoPedido);

        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Cuenta"));

        jLabel1.setText("Valor a Pagar:");

        totalPagar.setText("0");
        totalPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalPagarActionPerformed(evt);
            }
        });

        jLabel2.setText("Efectivo:");

        efectivo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        efectivo.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1000));

        btonPagar.setText("Pagar");
        btonPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btonPagarActionPerformed(evt);
            }
        });

        jLabel3.setText("Devuelta:");

        devuelta.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(devuelta, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btonPagar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(totalPagar, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(efectivo))))
                .addGap(25, 25, 25))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(totalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(efectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btonPagar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(devuelta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        listaMesas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaMesas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaMesasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaMesas);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pedidos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel2.setLayout(new java.awt.BorderLayout());

        botonEntregar.setText("Entregar");
        botonEntregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEntregarActionPerformed(evt);
            }
        });
        jPanel6.add(botonEntregar);

        jPanel2.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        tablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"fdf", null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Cliente", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaPedidos);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2);

        jLabel4.setText("Cliente:");

        jLabel5.setText("Sopa");

        jLabel6.setText("Principio");

        jLabel7.setText("Carne");

        chkEnsalada.setText("Ensalada");
        chkEnsalada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEnsaladaActionPerformed(evt);
            }
        });

        jLabel8.setText("Jugo");

        cmbJugo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbJugoActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        guardarPedido.setText("Guardar");
        guardarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarPedidoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Adicionales");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkEnsalada, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clienteNombre)
                            .addComponent(cmbSopas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbPrincipio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbCarne, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbEnsaldada, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbJugo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(guardarPedido)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(clienteNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbSopas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbPrincipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbCarne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkEnsalada)
                    .addComponent(cmbEnsaldada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(cmbJugo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(guardarPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void totalPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalPagarActionPerformed

    private void btonPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btonPagarActionPerformed
        try {
            var mesa = listaMesas.getSelectedValue();
            var total = (controlador.calcularValormesa(mesa));
            var efect = (Integer) efectivo.getValue();
            try {
                if (efect < total) {
                    throw new PagoExcepcion();
                }
                controlador.pagarCuenta(mesa);
                devuelta.setText(String.format("$ %d",efect-total));
               ((PedidoTable) tablaPedidos.getModel()).actializar();
            } catch (PagoExcepcion ex) {
                
                mostrarError("Error el efectivo es insuficiente,faltan: " +(total-efect));
                
            }
            
        } catch (SQLException ex) {
            
        }
    }//GEN-LAST:event_btonPagarActionPerformed

    private void listaMesasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaMesasValueChanged
        var mesaSelect = listaMesas.getSelectedValue();
        if (mesaSelect != null) {
            cargarInformacionMesa(mesaSelect);
        } else {
            
            
            limpiarValores();
            
        }
        limpiarCamposComida();
    }//GEN-LAST:event_listaMesasValueChanged

    private void chkEnsaladaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEnsaladaActionPerformed
        if (!chkEnsalada.isSelected()) {
            cmbEnsaldada.setEnabled(false);
        } else {
            cmbEnsaldada.setEnabled(true);
        }
    }//GEN-LAST:event_chkEnsaladaActionPerformed

    private void cmbJugoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbJugoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbJugoActionPerformed

    private void botonEntregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEntregarActionPerformed

        if(tablaPedidos.getSelectedRowCount()==1){
        try {
            var row = tablaPedidos.getSelectedRow();
            var pedido = ((PedidoTable) tablaPedidos.getModel()).getDato(row);
            controlador.entregarPedido(pedido);
            ((PedidoTable) tablaPedidos.getModel()).actializar();
            listaMesasValueChanged(null);//actualizo el valor de la mesa
            mostrarMensaje("El pedido ha sido entregado con exito!!");
            
        } catch (SQLException ex) {
            mostrarError("Error al entregar el pedido" + ex);
        }
        }
        else{
            mostrarAdvertencia("Advertencia,porfavor seleccione un pedido a entregar");
        }
    }//GEN-LAST:event_botonEntregarActionPerformed

    private void nuevoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoPedidoActionPerformed
        if (listaMesas.getSelectedValue() != null) {
            var mesa = listaMesas.getSelectedValue();
            
            tablaPedidos.clearSelection();
            limpiarCamposComida();
            clienteNombre.requestFocus();
        } else {
            mostrarAdvertencia("Porfavor primero seleccione una mesa");
        }
    }//GEN-LAST:event_nuevoPedidoActionPerformed

    private void guardarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarPedidoActionPerformed
        var mesaSelect = listaMesas.getSelectedValue();
        
        if (cmbCarne.getSelectedItem() != null && cmbJugo.getSelectedItem() != null && cmbSopas.getSelectedItem() != null
                && cmbPrincipio.getSelectedItem() != null && !clienteNombre.getText().equals("")) {
            
            try {
                ///guardo en la base de datos
                Corrientazo almuerzo = null;
                if (chkEnsalada.isSelected()) {
                    almuerzo = new Corrientazo(12_000,
                            (OpcionSopa) cmbSopas.getSelectedItem(),
                            (OpcionCarne) cmbCarne.getSelectedItem(),
                            (OpcionPrincipio) cmbPrincipio.getSelectedItem(),
                            (OpcionJugo) cmbJugo.getSelectedItem(),
                            (OpcionEnsalada) cmbEnsaldada.getSelectedItem());
                } else {
                    almuerzo = new Corrientazo(12_000,
                            (OpcionSopa) cmbSopas.getSelectedItem(),
                            (OpcionCarne) cmbCarne.getSelectedItem(),
                            (OpcionPrincipio) cmbPrincipio.getSelectedItem(),
                            (OpcionJugo) cmbJugo.getSelectedItem());
                }
                var pedido = new Pedido(clienteNombre.getText(), almuerzo);
                controlador.agregarPedido(mesaSelect, pedido);
                ((PedidoTable) tablaPedidos.getModel()).addDato(pedido);
                
            } catch (SQLException ex) {
                mostrarError("Error al guardar el pedido" + ex);
            }
        } else {
            mostrarError("Error porfavor llene todos los campos del pedido!");
        }
    }//GEN-LAST:event_guardarPedidoActionPerformed

    ///METODOS-------------------------------------------------------------------
    private void mostrarInformacionDelPedido() {
        if (tablaPedidos.getSelectedRowCount() == 1) {
            var row = tablaPedidos.getSelectedRow();
            var pedido = ((PedidoTable) tablaPedidos.getModel()).getDato(row);
            
            clienteNombre.setText(pedido.getCliente());
            cmbSopas.setSelectedItem(pedido.getAlmuerzo().getSopa());
            cmbCarne.setSelectedItem(pedido.getAlmuerzo().getCarne());
            cmbJugo.setSelectedItem(pedido.getAlmuerzo().getJugo());
            if (pedido.getAlmuerzo().getEnsalada() != null) {
                chkEnsalada.setSelected(true);
                cmbEnsaldada.setSelectedItem(pedido.getAlmuerzo().getEnsalada());
                
            } else {
                chkEnsalada.setSelected(false);
                
            }
            chkEnsaladaActionPerformed(null);
            cmbPrincipio.setSelectedItem(pedido.getAlmuerzo().getPrincipio());
            
        } else {
            limpiarCamposComida();
        }
    }
    
    public void limpiarCamposComida() {
        clienteNombre.setText("");
        cmbSopas.setSelectedIndex(-1);
        cmbCarne.setSelectedIndex(-1);
        cmbJugo.setSelectedIndex(-1);
        cmbEnsaldada.setSelectedIndex(-1);
        cmbPrincipio.setSelectedIndex(-1);
    }
    
    public void cargarListaDeMesas() {
        try {
            //cargar Mesas
            var mesas = controlador.listarMesas();
            listaMesas.removeAll();
            var model = new DefaultListModel<Mesa>();
            model.addAll(mesas);
            listaMesas.setModel(model);
            
        } catch (SQLException ex) {
            mostrarError(String.format("Error al cargar las mesas,err. %s", ex.getMessage()));
        }
    }
    
    private void limpiarValores() {
        totalPagar.setText(String.format("$ %d", 0));
         efectivo.setValue(String.format("$ %d", 0));
        devuelta.setText(String.format("$ %d", 0));
    }
    
    private void cargarOpcionesComida() {
        try {
            var sopas = controlador.getSopas();
            cmbSopas.removeAllItems();
            sopas.forEach(cmbSopas::addItem);
            
            var carnes = controlador.getCarnes();
            cmbCarne.removeAllItems();
            carnes.forEach(cmbCarne::addItem);
            
            var ensaldas = controlador.getEnsaladas();
            cmbEnsaldada.removeAllItems();
            ensaldas.forEach(cmbEnsaldada::addItem);
            
            var jugos = controlador.getJugos();
            cmbJugo.removeAllItems();
            jugos.forEach(cmbJugo::addItem);
            
            var principios = controlador.getPrincipios();
            cmbPrincipio.removeAllItems();
            principios.forEach(cmbPrincipio::addItem);
            
            limpiarCamposComida();
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void cargarInformacionMesa(Mesa mesa) {
        
        try {
            //valor de la mesa
            var valor = controlador.calcularValormesa(mesa);
            totalPagar.setText(String.format("$ %,d", valor));

            ///pedidos de la mesa
            var pedidos = controlador.listarPedidos(mesa);
            ((PedidoTable) tablaPedidos.getModel()).setDatos(pedidos);
            
        } catch (SQLException ex) {
            mostrarError("Error al cargar datos mesa " + ex);
        }
        
    }
    
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
            java.util.logging.Logger.getLogger(RestauranteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RestauranteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RestauranteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RestauranteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RestauranteGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEntregar;
    private javax.swing.JButton btonPagar;
    private javax.swing.JCheckBox chkEnsalada;
    private javax.swing.JTextField clienteNombre;
    private javax.swing.JComboBox<OpcionCarne> cmbCarne;
    private javax.swing.JComboBox<OpcionEnsalada> cmbEnsaldada;
    private javax.swing.JComboBox<OpcionJugo> cmbJugo;
    private javax.swing.JComboBox<OpcionPrincipio> cmbPrincipio;
    private javax.swing.JComboBox<OpcionSopa> cmbSopas;
    private javax.swing.JTextField devuelta;
    private javax.swing.JSpinner efectivo;
    private javax.swing.JButton guardarPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JList<Mesa> listaMesas;
    private javax.swing.JButton nuevoPedido;
    private javax.swing.JTable tablaPedidos;
    private javax.swing.JTextField totalPagar;
    // End of variables declaration//GEN-END:variables

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void mostrarAdvertencia(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    
}
