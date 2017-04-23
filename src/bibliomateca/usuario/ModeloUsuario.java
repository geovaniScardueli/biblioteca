/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliomateca.usuario;

import DTO.Livro;
import DTO.Usuario;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author isold
 */
public class ModeloUsuario extends AbstractTableModel {

    private ArrayList<Usuario> usuario = new ArrayList();
    private String[] columns = {"Sequencia", "Nome", "Multa", "Servidor"};
    
    @Override
    public int getRowCount() {
        return usuario.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return usuario.get(rowIndex).getSequencia();
                
            case 1:
                return usuario.get(rowIndex).getNome();
                
            case 2:
                return usuario.get(rowIndex).getValor_multa();
            
            case 3:
                return usuario.get(rowIndex).getTipo();
                
            default:
                return null;
        }
    }
    
    public void adicionarSelect(ArrayList<Usuario> usuario) {
        this.usuario = usuario;
        fireTableDataChanged();
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }
}
