/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliomateca.Emprestimo;

import DTO.Emprestimo;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author isold
 */
public class ModeloEmprestimo extends AbstractTableModel {

    private ArrayList<Emprestimo> emprestimo = new ArrayList();
    private String[] columns = {"Sequencia", "tituloLivro", "usuario", "emprestimo"};
    
    @Override
    public int getRowCount() {
        return emprestimo.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return emprestimo.get(rowIndex).getNrSequencia();
                
            case 1:
                return emprestimo.get(rowIndex).getTituloLivro();
                
            case 2:
                return emprestimo.get(rowIndex).getUsuario();
            
            case 3:
                return emprestimo.get(rowIndex).getEmprestimo();
                
            default:
                return null;
        }
    }
    
    public void adicionarSelect(ArrayList<Emprestimo> emprestimo) {
        this.emprestimo = emprestimo;
        fireTableDataChanged();
    }
}
