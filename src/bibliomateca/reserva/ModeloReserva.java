/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliomateca.reserva;

import DTO.Emprestimo;
import DTO.Reserva;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author isold
 */
public class ModeloReserva extends AbstractTableModel {

    private ArrayList<Reserva> reserva = new ArrayList();
    private String[] columns = {"Sequencia", "Usuário", "Livro"};

    @Override
    public int getRowCount() {
        return reserva.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: {
                return reserva.get(rowIndex).getSequencia();
            }
            case 1: {
                return reserva.get(rowIndex).getUsuario();
            }
            case 2: {
                return reserva.get(rowIndex).getLivro();
            }
            default: {
                return null;
            }
        }
    }

    public void adicionarSelect(ArrayList<Reserva> reserva) {
        this.reserva = reserva;
        fireTableDataChanged();
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }
    
}
