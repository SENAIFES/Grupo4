package entity;

import entity.Tarefa;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TarefaTableModel extends AbstractTableModel {

    public TarefaTableModel() {

    }

    private List<Tarefa> lista;

    //Getters and Setters
    public List<Tarefa> getLista() {
        return lista;
    }

    public void setLista(List<Tarefa> lista) {
        this.lista = lista;
    }

    public Tarefa getTarefa(int linha) {
        return lista.get(linha);
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tarefa umaTarefa = lista.get(rowIndex);
        if (columnIndex == 0) {
            return umaTarefa.getDescricao();
        } else if (columnIndex == 1) {
            return umaTarefa.getPrazo().getDate() + " / " + umaTarefa.getPrazo().getMonth() + " / " + (umaTarefa.getPrazo().getYear() + 1900);
        } else if (columnIndex == 2) {
            if (umaTarefa.isFeito()) {
                return "Sim";

            } else {
                return "Não";
            }
        } else {
            return "";

        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Descrição";
            case 1:
                return "Prazo";
            case 2:
                return "Feito";
            default:
                return "SemAtributo";

        }

    }

}
