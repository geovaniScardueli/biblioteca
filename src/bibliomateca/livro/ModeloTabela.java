/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliomateca.livro;

import DTO.Livro;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author isold
 */
public class ModeloTabela extends AbstractTableModel {

    private ArrayList<Livro> livros = new ArrayList();
    private String[] columns = {"Sequencia", "Titulo",
        "classificacao"};

    @Override
    public int getRowCount() {
        return livros.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex) {
            case 0:
                return livros.get(rowIndex).getNrSequencia();
                
            case 1:
                return livros.get(rowIndex).getTitulo();
                
            case 2:
                return livros.get(rowIndex).getClassificacao();
                
            default:
                return null;
        }
    }
    
    public void addLivro(Livro livro) {
        livros.add(livro);
        fireTableDataChanged();
    }
    
    public void adicionarSelect(ArrayList<Livro> lista) {
        livros = lista;
        fireTableDataChanged();
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

}
