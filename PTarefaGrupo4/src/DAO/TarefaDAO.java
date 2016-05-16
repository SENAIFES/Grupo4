package DAO;

import entity.Lista;
import entity.Tarefa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO {

    public boolean salvar(Tarefa tarefa) {
        if (tarefa.getId() == 0) {
            return insert(tarefa);
        } else {
            return update(tarefa);
        }
    }

    private boolean insert(Tarefa tarefa) {
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO `dbtarefa`.`tarefa` (  `idlista` ,`Descrisao`, `Prazo`, `Feito` ) VALUES (?,?, ?, ?);");
            ps.setInt(1, tarefa.getIdLista());
            ps.setString(2, tarefa.getDescricao());
            ps.setDate(3, new Date(tarefa.getPrazo().getTime()));
            ps.setBoolean(4, tarefa.isFeito());
            ps.execute();
            ps.close();
            conn.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private boolean update(Tarefa tarefa) {
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE `dbtarefa`.`tarefa` SET `Descrisao`= ?  , `Prazo`=?, `Feito`= ? ,` idlista`=? , WHERE `idTarefa`= ? ;");
            ps.setString(1, tarefa.getDescricao());
            ps.setDate(2, new Date(tarefa.getPrazo().getTime()));
            ps.setBoolean(3, tarefa.isFeito());
            ps.setInt(4, tarefa.getIdLista());
            ps.setInt(5, tarefa.getId());

            ps.execute();

            ps.close();
            conn.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement ps
                    = conn.prepareStatement("DELETE FROM `dbtarefa`.`tarefa` WHERE `idTarefa`=?;");
            ps.setInt(1, id);

            ps.execute();

            ps.close();
            conn.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public List< Tarefa> listarTodos() {
        List< Tarefa> lista = new ArrayList< Tarefa>();
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement ps
                    = conn.prepareStatement("SELECT idtarefa,descricao,prazo,feito, idlista , FROM dbtarefa.tarefa;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Tarefa tarefa = new Tarefa();
                tarefa.setId(rs.getInt("idtarefa"));
                tarefa.setDescricao(rs.getString("descrisao"));
                tarefa.setPrazo(new java.util.Date(rs.getDate("prazo").getTime()));
                tarefa.setFeito(rs.getBoolean("feito"));
                tarefa.setIdLista(rs.getInt(" idlista "));
                lista.add(tarefa);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List< Tarefa> listarTodosPorIDLista(Lista objLista) {
        List< Tarefa> lista = new ArrayList< Tarefa>();
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement ps
                    = conn.prepareStatement("SELECT idlista ,idtarefa,descrisao,prazo,feito FROM dbtarefa.tarefa where idLista=?;");
            ps.setInt(1, objLista.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Tarefa tarefa = new Tarefa();
                tarefa.setId(rs.getInt("idtarefa"));
                tarefa.setDescricao(rs.getString("descrisao"));
                tarefa.setPrazo(new java.util.Date(rs.getDate("prazo").getTime()));
                tarefa.setFeito(rs.getBoolean("feito"));
                tarefa.setIdLista(rs.getInt("idlista"));
                lista.add(tarefa);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
//////

    public Tarefa BuscarPorId(int id) {
        Connection conn = ConnectionManager.getConnection();
        Tarefa tarefa = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT idtarefa,descrisao,prazo,feito FROM dbtarefa.tarefa WHERE idtarefa LIKE ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tarefa = new Tarefa();
                tarefa.setId(rs.getInt("idtarefa"));
                tarefa.setDescricao(rs.getString("descrisao"));
                tarefa.setPrazo(new java.util.Date(rs.getDate("prazo").getTime()));
                tarefa.setFeito(rs.getBoolean("feito"));
            }
            rs.close();
            ps.close();
            conn.close();
            return tarefa;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
