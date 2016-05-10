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

public class ListaDAO {

    public boolean salvar(Lista lista) {
        if (lista.getId() == 0) {
            return insert(lista);
        } else {
            return update(lista);
        }
    }

    private boolean insert(Lista lista) {
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO `dbtarefa`.`lista` (`Descricao`) VALUES (?);");
            ps.setString(1, lista.getDescricao());

            ps.execute();
            ps.close();
            conn.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private boolean update(Lista lista) {
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE `dbtarefa`.`lista` SET `Descricao`='??' WHERE `idLista`=?;");
            ps.setString(1, lista.getDescricao());
            ps.setInt(2, lista.getId());

            ps.execute();

            ps.close();
            conn.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean delete(Lista lista) {
        Connection conn = ConnectionManager.getConnection();
        int id = lista.getId();
        try {
            PreparedStatement ps
                    = conn.prepareStatement("DELETE FROM `dbtarefa`.`lista` WHERE `idLista`=?;");
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

    public List< Lista> listarTodos() {
        List< Lista> lista = new ArrayList< Lista>();
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement ps
                    = conn.prepareStatement("SELECT idLista, Descricao FROM dbtarefa.lista;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Lista objLista;
                objLista = new Lista();

                objLista.setId(rs.getInt("idLista"));
                objLista.setDescricao(rs.getString("Descricao"));
                lista.add(objLista);
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

    public Lista BuscarPorId(int id) {
        Connection conn = ConnectionManager.getConnection();
        Lista lista = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT idLista, Descricao FROM dbtarefa.lista WHERE idLista LIKE ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista = new Lista();
                lista.setId(rs.getInt("idtarefa"));
                lista.setDescricao(rs.getString("descricao"));
            }
            rs.close();
            ps.close();
            conn.close();
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
