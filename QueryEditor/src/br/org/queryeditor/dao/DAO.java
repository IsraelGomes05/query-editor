package br.org.queryeditor.dao;

import br.org.queryeditor.model.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Função<br>.
 *
 * created 05/08/2018<br>
 * lastModified 05/08/2018
 *
 * @author Israel Gomes
 * @version 1.0
 * @since 1.0
 */
public class DAO {

    public ArrayList<Data> executeQuery(String sql, Connection con) throws SQLException {
        ArrayList<Data> dados = new ArrayList();
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            this.preencherDados(rs, dados);
            return dados;
        }
        return null;
    }

    public void executeUpdate(String sql, Connection con) {

    }

    public ArrayList<Data> preencherDados(ResultSet rs, ArrayList<Data> colecao) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int cont = 1; cont <= columnCount; cont++) {
            Data data = new Data();
            data.setIndex(cont);
            data.setNomeColuna(metaData.getColumnName(cont));
            data.setTipoDadoColuna(metaData.getColumnTypeName(cont));
            colecao.add(data);
        }

        do {
            for (Data coluna : colecao) {
                coluna.setDados(rs.getObject(coluna.getIndex()));
            }
        } while (rs.next());

        return colecao;
    }

}
