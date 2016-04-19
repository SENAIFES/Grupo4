package entity;

import java.util.Date;
import javafx.scene.chart.PieChart;

public class Tarefa {
    
    private String descricao;
    private Date prazo;
    private boolean feito;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public boolean isFeito() {
        return feito;
    }

    public void setFeito(boolean feito) {
        this.feito = feito;
    }
    
}
