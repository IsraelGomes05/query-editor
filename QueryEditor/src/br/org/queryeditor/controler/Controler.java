package br.org.queryeditor.controler;

import br.org.queryeditor.dao.DAO;
import br.org.queryeditor.forms.QueryTelaPrincipal;
import br.org.queryeditor.model.Data;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public Controler(QueryTelaPrincipal view) {
        this.view = view;
        this.dao = new DAO();
        this.jtbResultadosModel = (DefaultTableModel) view.getTabelaResultados().getModel();
    }

    public void executarQuery(Connection con) {
        try {

            RSyntaxTextArea editor = view.getEditorSelecionado();
            if (editor != null) {
                String query = editor.getText();
                ArrayList<Data> dados = new ArrayList();

                dados = this.dao.executeQuery(query, con);
                if (dados != null) {
                    this.preencherTabela(dados);
                }
            }
        } catch (SQLException ex) {
            view.exibirMensagen(ex.getMessage());
        }
    }
    
    public void preencherTabela(ArrayList<Data> dados) {
        for (Data dado : dados) {
            jtbResultadosModel.addColumn(dado.getNomeColuna().toUpperCase().concat(" " + dado.getTipoDadoColuna()));
        }
    }
    
}
