/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliomateca.exemplar;

import DTO.Exemplar;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author isold
 */
public class ModeloExemplar extends AbstractTableModel {

    private ArrayList<Exemplar> exemplar = new ArrayList();
    private String[] columns = {"Sequencia", "cod barras", "Patrimonio"};
    
    @Override
    public int getRowCount() {
        return exemplar.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return exemplar.get(rowIndex).getNrSequencia();
                
            case 1:
                return exemplar.get(rowIndex).getCodigoBarra();
                
            case 2:
                return exemplar.get(rowIndex).getPatrimonio();
            
            default:
                return null;
        }
    }
    
    public void adicionarSelect(ArrayList<Exemplar> exemplar) {
        this.exemplar = exemplar;
        fireTableDataChanged();
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }
}
