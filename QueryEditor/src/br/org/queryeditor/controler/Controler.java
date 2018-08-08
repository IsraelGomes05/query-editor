package br.org.queryeditor.controler;

import br.org.queryeditor.controler.util.Enumerated;
import br.org.queryeditor.dao.DAO;
import br.org.queryeditor.forms.QueryTelaPrincipal;
import br.org.queryeditor.model.Info;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

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
public class Controler {

    private final QueryTelaPrincipal view;
    private final DAO dao;
    private DefaultTableModel jtbResultadosModel;
    private final JTable tabelaResultados;

    public Controler(QueryTelaPrincipal view) {
        this.view = view;
        this.dao = new DAO();
        this.jtbResultadosModel = (DefaultTableModel) view.getTabelaResultados().getModel();
        this.tabelaResultados = view.getTabelaResultados();
    }

    public void executarQuery(Connection con) {
        try {
            RSyntaxTextArea editor = view.getEditorSelecionado();
            if (editor != null) {
                String query = editor.getText();
                ArrayList<Info> dados;

                if (query.isEmpty()) {
                    view.exibirMensagen(Enumerated.TipoMsg.ERRO, "A Query não pode estar vazia", true);
                    return;
                }
                
                dados = this.dao.executeQuery(query, con);
                if (! dados.isEmpty()) {
                    this.preencherTabela(dados);
                } else {
                view.exibirMensagen(Enumerated.TipoMsg.AVISO, "Query ok, nenhum registro encontrado", true);
                }
            }
        } catch (SQLException ex) {
            view.exibirMensagen(Enumerated.TipoMsg.ERRO, ex.getMessage(), true);
        }
    }

    public void preencherTabela(ArrayList<Info> dados) {
        long qtdLinhas;
        try {
            int qtdColunas = dados.size();

            qtdLinhas = dados.get(0).getDados().size();
            Object[] linhaTabela = new Object[qtdColunas];

            this.limparTabela();
            for (Info dado : dados) {
                jtbResultadosModel.addColumn(dado.getNomeColuna().toUpperCase().concat(" (" + dado.getTipoDadoColuna().toLowerCase() + ")"));
            }

            for (int linha = 0; linha < qtdLinhas; linha++) {
                for (int coluna = 0; coluna < qtdColunas; coluna++) {
                    linhaTabela[coluna] = dados.get(coluna).getDados().get(linha);
                }
                jtbResultadosModel.addRow(linhaTabela);
            }
            view.exibirMensagen(Enumerated.TipoMsg.INFO, "Query ok, " + qtdLinhas + (qtdLinhas > 1 ? " linhas encontradas" : " linha encontrada"), false);
        } catch (Exception ex) {
            view.exibirMensagen(Enumerated.TipoMsg.ERRO, ex.getMessage(), true);
        }
    }

    public void limparTabela() {
        if (this.tabelaResultados.getColumnCount() > 0) {
            this.jtbResultadosModel.setNumRows(0);
            this.tabelaResultados.removeAll();
            this.jtbResultadosModel.setColumnCount(0);
            this.tabelaResultados.repaint();
            this.tabelaResultados.revalidate();
        }
    }
}
