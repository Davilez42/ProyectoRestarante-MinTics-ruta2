/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.utp.corrientazo.vista.gui.modelogui;

import com.edu.utp.corrientazo.modelo.EstadoPedido;
import com.edu.utp.corrientazo.modelo.Pedido;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author joses
 */
public class PedidoTable extends AbstractTableModel {

    private List<Pedido> datos;

    public PedidoTable() {
        datos = new ArrayList<>();
    }

    public void setDatos(List<Pedido> datos) {
        this.datos = datos;
        fireTableDataChanged();
    }
    public void addDato(Pedido pedido){
        datos.add(pedido);
        var row = datos.size()-1;
        fireTableRowsInserted(row,row );

    }

    @Override
    public int getRowCount() {
       return datos.size();
    }

    @Override
    public int getColumnCount() {
       return 2;
    }

    @Override
    public Object getValueAt(int row, int colum) {
        var dato = datos.get(row);
        switch(colum){
            case 0:
                return dato.getCliente();
            case 1:
                return dato.getEstado()==EstadoPedido.PENDIENTE_COBRAR;
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
          switch(column){
            case 0:
                return "Nombre";
            case 1:
                return "Entregado";
                
        }
        return super.getColumnName(column); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Class<?> getColumnClass(int column) {
           switch(column){
            case 0:
                return String.class;
            case 1:
                return Boolean.class;
                
        }
        return super.getColumnClass(column); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Pedido getDato(Integer row){
        return this.datos.get(row);
    }
    
    
    public void actializar(){
        fireTableDataChanged();
    }
    

}
