package br.org.queryeditor.controler;

import br.org.queryeditor.controler.util.Enumerated;
import br.org.queryeditor.controler.util.Exportacao;
import br.org.queryeditor.controler.util.StringUtils;
import br.org.queryeditor.controler.util.WebUtil;
import br.org.queryeditor.dao.DAO;
import br.org.queryeditor.forms.Login;
import br.org.queryeditor.forms.QueryTelaPrincipal;
import br.org.queryeditor.model.Info;
import br.org.queryeditor.model.Tabela;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

/**
 * Classe responsável pelas regras de negócio.<br>
 *
 * created 05/08/2018<br>
 * lastModified 05/08/2018
 *
 * @author Israel Gomes
 * @version 1.0
 * @since 1.0
 */
public class PrincipalControler {

    private final QueryTelaPrincipal view;
    private final DAO dao;
    private final DefaultTableModel jtbResultadosModel;
    private final JTable tabelaResultados;
    private final String localArquivo;

    public PrincipalControler(QueryTelaPrincipal view) {
        this.view = view;
        this.dao = new DAO();
        this.jtbResultadosModel = (DefaultTableModel) view.getTabelaResultados().getModel();
        this.tabelaResultados = view.getTabelaResultados();
        this.localArquivo = view.getLocalQuerys();
    }

    /**
     * Executa uma consulta no banco de dodos.
     *
     * @param con Conexãao com o banco de dados.
     */
    public void executarQuery(Connection con) {
        try {
            RSyntaxTextArea editor = view.getEditorSelecionado();
            if (editor != null) {
                String querySelecionada = editor.getSelectedText();
                String query = editor.getText().trim();
                if (querySelecionada != null) {
                    query = querySelecionada;
                }
                
                if (!view.isPermitirAlteracoes()) {
                    if (!this.verificarOperacao(query)) {
                        return;
                    }
                }

                ArrayList<Info> dados;
                if (query.isEmpty()) {
                    view.exibirMensagen(Enumerated.TipoMsg.ERRO, "A Query não pode estar vazia", true);
                    return;
                }
                
                 for (String sql : query.split(";")) {
                    dados = this.dao.executeQuery(sql, con);
                    if (!dados.isEmpty()) {
                        this.preencherTabela(dados);
                    } else {
                        view.exibirMensagen(Enumerated.TipoMsg.AVISO, "Query ok, nenhum registro encontrado", true);
                        this.limparTabela();
                    }
                }
            }
        } catch (SQLException ex) {
            view.exibirMensagen(Enumerated.TipoMsg.ERRO, ex.getMessage(), true);
        }
    }

    /**
     * Preenche a tabela de resultados.
     *
     * @param dados lista preenchida.
     */
    public void preencherTabela(ArrayList<Info> dados) {
        long qtdLinhas;
        try {
            if (!dados.get(0).isSelect()) {
                view.exibirMensagen(Enumerated.TipoMsg.INFO, "Query ok, {0} linhas afetadas ".replace("{0}", "" + dados.get(0).getLinhasAfetadas()), true);
                return;
            }
            qtdLinhas = dados.get(0).getDados().size();
            int qtdColunas = dados.size();
            int cont = 0;
            Object[] linhaTabela = new Object[qtdColunas];
            String[] tiposDeDados = new String[qtdColunas];

            this.limparTabela();
            for (Info dado : dados) {
                jtbResultadosModel.addColumn(dado.getNomeColuna().toUpperCase().concat(" (" + dado.getTipoDadoColuna().toLowerCase() + ")"));
                tiposDeDados[cont] = dado.getTipoDadoColuna();
                cont++;
            }

            for (int linha = 0; linha < qtdLinhas; linha++) {
                for (int coluna = 0; coluna < qtdColunas; coluna++) {
                    Object dado = dados.get(coluna).getDados().get(linha);
                    linhaTabela[coluna] = (dado == null ? "null" : (tiposDeDados[coluna].contains("BLOB") ? "[ Blob ]" : dado.toString()));
                }
                jtbResultadosModel.addRow(linhaTabela);
            }
            view.rendimensionarTabela();
            view.exibirMensagen(Enumerated.TipoMsg.INFO, "Query ok, " + qtdLinhas + (qtdLinhas > 1 ? " linhas encontradas" : " linha encontrada"), false);
        } catch (Exception ex) {
            view.exibirMensagen(Enumerated.TipoMsg.ERRO, ex.getMessage(), true);
        }
    }

    /**
     * Limpa a tebela de resultados.
     */
    public void limparTabela() {
        if (this.tabelaResultados.getColumnCount() > 0) {
            this.jtbResultadosModel.setNumRows(0);
            this.tabelaResultados.removeAll();
            this.jtbResultadosModel.setColumnCount(0);
            this.tabelaResultados.repaint();
            this.tabelaResultados.revalidate();
        }
    }

    public void exportarSaida() {
        Exportacao.exportarParaExel(view, tabelaResultados);
    }

    public HashMap<String, String> getQuerysMap() {
        String[] vetorQuerys;
        HashMap<String, String> querysMap = new HashMap();
            String arquivoQuerys = this.getTextoHistoricoQuerys();
            vetorQuerys = arquivoQuerys.split("]");
            for (String var : vetorQuerys) {
                String[] query;
                query = var.split("\\|");
                if (query.length < 2) {
                    continue;
                }
                querysMap.put((query[0].replace("[", "").trim()).replace("\r\n", ""), query[1].trim());
            }
        return querysMap;
    }

    public String getTextoHistoricoQuerys() {
        String arquivoQuerys = "";
        try {
            if ((this.localArquivo != null) && !this.localArquivo.isEmpty()) {
                if (localArquivo.contains("dontpad")) {
                    arquivoQuerys = WebUtil.get(this.localArquivo);
                    arquivoQuerys = this.getApenasConteudoDontPad(arquivoQuerys);
                } else {
                    File file = new File(this.localArquivo);
                    arquivoQuerys = StringUtils.lerArquivo(file);
                }
            }
        } catch (Exception ex) {
            view.exibirMensagen(Enumerated.TipoMsg.ERRO, ex.getMessage(), true);
        } 
        return arquivoQuerys;
    }

    public void carregarQuery(String query) {
        RSyntaxTextArea editor = view.getEditorSelecionado();
        if (editor != null) {
            String queryAtual = editor.getText() == null ? "" : editor.getText();
            queryAtual = queryAtual.concat("\n" + query);
            editor.setText(queryAtual);
            return;
        }
        view.exibirMensagen(Enumerated.TipoMsg.ERRO, "Nenhum editor selecionado!", true);
    }

    public List<Tabela> getMapeamentoBd(Connection con) {
        ArrayList<Tabela> tabelasBd = new ArrayList();
        try {
            tabelasBd = dao.mapearBancoDeDados(con);
        } catch (SQLException ex) {
            view.exibirMensagen(Enumerated.TipoMsg.ERRO, ex.getMessage(), true);
        }
        return tabelasBd;
    }

    public void atualizarArquivoQuerys(HashMap<String, String> querys) {
        try {
            String saida = "";
            for (String titulo : querys.keySet()) {
                String query = querys.get(titulo);
                saida = saida.concat(String.format("[%s|%s] \r\n", titulo, query));
            }
            StringUtils.escreverArquivo(view.getLocalQuerys(), saida);
            JOptionPane.showMessageDialog(view, "Arquivo Atualizado com sucesso");
        } catch (IOException ex) {
            view.exibirMensagen(Enumerated.TipoMsg.ERRO, ex.getMessage(), true);
        }
    }

    public boolean verificarOperacao(String query) {
        String queryVerificacao = query.toUpperCase();
        if (queryVerificacao.contains("UPDATE") || queryVerificacao.contains("DELETE") || queryVerificacao.contains("ALTER") || queryVerificacao.contains("DROP")) {
            Login login = new Login(null, true, view.getSenhaParaAteracoes());
            login.setVisible(true);
            return login.isDadosCorretos();
        }
        return true;
    }

    private String getApenasConteudoDontPad(String arquivoQuerys) {
        if (arquivoQuerys != null && !arquivoQuerys.isEmpty()) {
            String substring = arquivoQuerys.substring(arquivoQuerys.indexOf("textarea"), arquivoQuerys.indexOf("</textarea>"));
             
            return substring.substring(substring.indexOf("["), substring.length());
        } else {
            return "";
        }
    }
}
