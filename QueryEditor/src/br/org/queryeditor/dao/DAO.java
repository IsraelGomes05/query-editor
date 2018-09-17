package br.org.queryeditor.dao;

import br.org.queryeditor.model.Info;
import br.org.queryeditor.model.LinhaTabela;
import br.org.queryeditor.model.Tabela;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe responsável pela execução de ações no banco de dados.<br>
 *
 * created 05/08/2018<br>
 * lastModified 08/08/2018
 *
 * @author Israel Gomes
 * @version 1.0
 * @since 1.0
 */
public class DAO {

    /**
     * Executa uma <b>Consulta no banco de dados.</b>
     *
     * @param sql Query a ser executada.
     * @param con Conexão com o banco de dados.
     * @return Lista preenchida com os resultados da consulta, ou uma lista
     * vazia, caso não seja encontrado nada.
     * @throws SQLException
     */
    public ArrayList<Info> executeQuery(String sql, Connection con) throws SQLException {
        int numLinhasAfetadas;
        this.mapearBancoDeDados(con);
        ArrayList<Info> dados = new ArrayList();
        PreparedStatement stm = con.prepareStatement(sql);
        boolean isSelect = stm.execute();
        numLinhasAfetadas = stm.getUpdateCount();

        stm.getUpdateCount();

        if (isSelect) {
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                this.preencherDados(rs, dados);
                return dados;
            }
        } else {
            Info dado = new Info();
            dado.setLinhasAfetadas(numLinhasAfetadas);
            dado.setSelect(false);
            dados.add(dado);
        }

        return dados;
    }

    public void executeUpdate(String sql, Connection con) throws SQLException {
        PreparedStatement stm = con.prepareStatement(sql);

        int rs = stm.executeUpdate();
    }

    /**
     * Preenche uma lista com o ResultSet.
     *
     * @param rs ResultSet preenchido.
     * @param colecao Lista a ser preenchida com os resultados.
     * @return Lista preenchida com o ResultSet.
     * @throws SQLException
     */
    public ArrayList<Info> preencherDados(ResultSet rs, ArrayList<Info> colecao) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int cont = 1; cont <= columnCount; cont++) {
            Info data = new Info();
            data.setIndex(cont);
            data.setSelect(true);
            data.setNomeColuna(metaData.getColumnName(cont));
            data.setTipoDadoColuna(metaData.getColumnTypeName(cont));
            colecao.add(data);
        }

        do {
            for (Info coluna : colecao) {
                coluna.setDados(rs.getObject(coluna.getIndex()));
            }
        } while (rs.next());

        return colecao;
    }

    public ArrayList<Tabela> mapearBancoDeDados(Connection con) throws SQLException {
        ArrayList<Tabela> tabelasList = new ArrayList();
        ArrayList<LinhaTabela> linhaTabela;

        DatabaseMetaData metaData = con.getMetaData();
        ResultSet res = metaData.getTables(null, null, null, new String[]{"TABLE"});

        while (res.next()) {
            String nomeTabela = res.getString(3);
            ResultSet columns = metaData.getColumns(null, null, nomeTabela, null);
            linhaTabela = new ArrayList();
            while (columns.next()) {
                String coluna = columns.getString(4);
                String tipoDeDados = columns.getString(6);
                linhaTabela.add(new LinhaTabela(coluna, tipoDeDados));
            }
            tabelasList.add(new Tabela(nomeTabela, linhaTabela));
        }
        return tabelasList;
    }

}
