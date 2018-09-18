package br.org.queryeditor.forms;

import br.org.queryeditor.controler.PrincipalControler;
import br.org.queryeditor.controler.TabelaTreeModel;
import br.org.queryeditor.controler.Template;
import br.org.queryeditor.controler.util.Enumerated;
import br.org.queryeditor.forms.formsutil.ButtonTabComponent;
import br.org.queryeditor.forms.formsutil.JTreeRenderer;
import br.org.queryeditor.forms.formsutil.RenderizadorTabela;
import br.org.queryeditor.forms.formsutil.ViewUtil;
import br.org.queryeditor.model.LinhaTabela;
import br.org.queryeditor.model.Tabela;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

/**
 * Tela principal da aplicação<br>
 *
 * created 05/08/2018<br>
 * lastModified 08/08/2018
 *
 * @author Israel Gomes
 * @version 1.0
 * @since 1.0
 */
public class QueryTelaPrincipal extends javax.swing.JDialog {

    private int tab = 0;
    private static Connection conexaoBd;
    private PrincipalControler controler;
    private RSyntaxTextArea txtEditor;
    private DefaultTableModel msgTabelaModel;
    private String localQuerys;
    private SeletorQuerys seletorQuerys;
    private TabelaTreeModel treeModel;
    private ViewUtil viewUtil = new ViewUtil();
    private HashMap<String, String> querys;
    private java.awt.Frame parente;
    private boolean permitirAlteracoes;
    private String senhaParaAteracoes;
    
    /**
     * Cria e exibe a tela principal.
     *
     * @param parent Tela a qual esta herdará as propriedades.
     * @param modal Se a tela que chamou esta, poderá ser acessada ou não com
     * esta em execução.
     * @param conexao Conexão com o banco de dados.
     * @param localQuerys Local onde está o arquivo de texto com as querys
     * @param permitirAlteracoes
     */
    public QueryTelaPrincipal(java.awt.Frame parent, boolean modal, Connection conexao, String localQuerys, boolean permitirAlteracoes, String senhaParaAteracoes) {
        super(parent, modal);
        initComponents();
        try {
            this.parente = parent;
            conexaoBd = conexao;
            this.setTitle(parent.getTitle() + " SQL Editor");
            this.localQuerys = localQuerys;
            this.controler = new PrincipalControler(this);
            this.msgTabelaModel = (DefaultTableModel) this.jtbMensagens.getModel();
            jtbMensagens.setDefaultRenderer(Object.class, new RenderizadorTabela());
            jtbResultados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

            if ((this.localQuerys != null) && (!this.localQuerys.isEmpty())) {
                querys = controler.getQuerysMap();
                this.seletorQuerys = new SeletorQuerys(parent, true, querys);
            }
            this.treeModel = new TabelaTreeModel(controler.getMapeamentoBd(conexaoBd), "BD");
            this.jTreeBancoDeDados.setModel(treeModel);
            this.setIconesJtree();
            this.permitirAlteracoes = permitirAlteracoes;
            this.senhaParaAteracoes = senhaParaAteracoes;
        } catch (Exception e) {
            this.exibirMensagen(Enumerated.TipoMsg.ERRO, e.getMessage(), true);
        }
    }

    public QueryTelaPrincipal() {
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jppmOpcoesTabelaResultados = new javax.swing.JPopupMenu();
        jmExportarParaExel = new javax.swing.JMenuItem();
        jpnTelaPrincipal = new javax.swing.JPanel();
        jpnMenu = new javax.swing.JPanel();
        btnAdicionarTab = new javax.swing.JButton();
        btnExecutar = new javax.swing.JButton();
        btnHistorico = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jSplitPane2 = new javax.swing.JSplitPane();
        jpnQueryEditor = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jpnSuperior = new javax.swing.JPanel();
        jpnNavegacao = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTreeBancoDeDados = new javax.swing.JTree();
        jtbpQueryEditors = new javax.swing.JTabbedPane();
        jpnResult = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jtbpResultados = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbResultados = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtbMensagens = new javax.swing.JTable();

        jmExportarParaExel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/queryeditor/imagens/icons8-ms-excel-16.png"))); // NOI18N
        jmExportarParaExel.setText("Exportar Para Excel");
        jmExportarParaExel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmExportarParaExelActionPerformed(evt);
            }
        });
        jppmOpcoesTabelaResultados.add(jmExportarParaExel);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));

        jpnMenu.setBackground(new java.awt.Color(44, 62, 80));
        jpnMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        btnAdicionarTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/queryeditor/imagens/icons8-nova-janela-filled-36.png"))); // NOI18N
        btnAdicionarTab.setToolTipText("Novo Editor");
        btnAdicionarTab.setBorderPainted(false);
        btnAdicionarTab.setContentAreaFilled(false);
        btnAdicionarTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdicionarTab.setRolloverEnabled(true);
        btnAdicionarTab.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/queryeditor/imagens/icons8-nova-janela-filled-36 verde.png"))); // NOI18N
        btnAdicionarTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarTabActionPerformed(evt);
            }
        });

        btnExecutar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/queryeditor/imagens/icons8-executar-comando-filled-36-amarelo.png"))); // NOI18N
        btnExecutar.setToolTipText("Executar");
        btnExecutar.setBorderPainted(false);
        btnExecutar.setContentAreaFilled(false);
        btnExecutar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExecutar.setRolloverEnabled(true);
        btnExecutar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/queryeditor/imagens/icons8-executar-comando-filled-36.png"))); // NOI18N
        btnExecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExecutarActionPerformed(evt);
            }
        });

        btnHistorico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/queryeditor/imagens/icons8-lista-36-amarelo.png"))); // NOI18N
        btnHistorico.setToolTipText("Histórico de Querys");
        btnHistorico.setBorderPainted(false);
        btnHistorico.setContentAreaFilled(false);
        btnHistorico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHistorico.setRolloverEnabled(true);
        btnHistorico.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/queryeditor/imagens/icons8-lista-36.png"))); // NOI18N
        btnHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoricoActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/queryeditor/imagens/icons8-salvar-36-amarelo.png"))); // NOI18N
        btnSalvar.setToolTipText("Salvar");
        btnSalvar.setBorderPainted(false);
        btnSalvar.setContentAreaFilled(false);
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.setRolloverEnabled(true);
        btnSalvar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/queryeditor/imagens/icons8-salvar-36.png"))); // NOI18N
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdicionarTab, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnExecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAdicionarTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnExecutar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnHistorico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jSplitPane2.setDividerLocation(400);
        jSplitPane2.setDividerSize(4);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jScrollPane6.setViewportView(jTreeBancoDeDados);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6)
        );

        jScrollPane5.setViewportView(jPanel2);

        javax.swing.GroupLayout jpnNavegacaoLayout = new javax.swing.GroupLayout(jpnNavegacao);
        jpnNavegacao.setLayout(jpnNavegacaoLayout);
        jpnNavegacaoLayout.setHorizontalGroup(
            jpnNavegacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNavegacaoLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpnNavegacaoLayout.setVerticalGroup(
            jpnNavegacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
        );

        javax.swing.GroupLayout jpnSuperiorLayout = new javax.swing.GroupLayout(jpnSuperior);
        jpnSuperior.setLayout(jpnSuperiorLayout);
        jpnSuperiorLayout.setHorizontalGroup(
            jpnSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSuperiorLayout.createSequentialGroup()
                .addComponent(jpnNavegacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtbpQueryEditors, javax.swing.GroupLayout.PREFERRED_SIZE, 1052, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnSuperiorLayout.setVerticalGroup(
            jpnSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnNavegacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jtbpQueryEditors, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jScrollPane1.setViewportView(jpnSuperior);

        javax.swing.GroupLayout jpnQueryEditorLayout = new javax.swing.GroupLayout(jpnQueryEditor);
        jpnQueryEditor.setLayout(jpnQueryEditorLayout);
        jpnQueryEditorLayout.setHorizontalGroup(
            jpnQueryEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jpnQueryEditorLayout.setVerticalGroup(
            jpnQueryEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
        );

        jSplitPane2.setTopComponent(jpnQueryEditor);

        jScrollPane2.setToolTipText("");
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jtbResultados.setAutoCreateRowSorter(true);
        jtbResultados.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jtbResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtbResultados.setAutoscrolls(false);
        jtbResultados.setShowHorizontalLines(false);
        jtbResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbResultadosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtbResultados);

        jtbpResultados.addTab("Resultados", jScrollPane3);

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setToolTipText("");
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jtbMensagens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbMensagens.setRowSelectionAllowed(false);
        jtbMensagens.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jtbMensagens.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtbMensagens.setShowHorizontalLines(false);
        jtbMensagens.setShowVerticalLines(false);
        jScrollPane4.setViewportView(jtbMensagens);
        if (jtbMensagens.getColumnModel().getColumnCount() > 0) {
            jtbMensagens.getColumnModel().getColumn(0).setMinWidth(100);
            jtbMensagens.getColumnModel().getColumn(0).setPreferredWidth(50);
            jtbMensagens.getColumnModel().getColumn(0).setMaxWidth(400);
        }

        jtbpResultados.addTab("Mensagens", jScrollPane4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbpResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 1245, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbpResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout jpnResultLayout = new javax.swing.GroupLayout(jpnResult);
        jpnResult.setLayout(jpnResultLayout);
        jpnResultLayout.setHorizontalGroup(
            jpnResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jpnResultLayout.setVerticalGroup(
            jpnResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
        );

        jSplitPane2.setRightComponent(jpnResult);

        javax.swing.GroupLayout jpnTelaPrincipalLayout = new javax.swing.GroupLayout(jpnTelaPrincipal);
        jpnTelaPrincipal.setLayout(jpnTelaPrincipalLayout);
        jpnTelaPrincipalLayout.setHorizontalGroup(
            jpnTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jpnTelaPrincipalLayout.setVerticalGroup(
            jpnTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTelaPrincipalLayout.createSequentialGroup()
                .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSplitPane2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnTelaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnTelaPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarTabActionPerformed
        this.adicionarTab();
    }//GEN-LAST:event_btnAdicionarTabActionPerformed

    private void btnExecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecutarActionPerformed
        this.controler.executarQuery(QueryTelaPrincipal.conexaoBd);
    }//GEN-LAST:event_btnExecutarActionPerformed

    private void jtbResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbResultadosMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            jppmOpcoesTabelaResultados.show(jtbResultados, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jtbResultadosMouseClicked

    private void jmExportarParaExelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmExportarParaExelActionPerformed
        controler.exportarSaida();
    }//GEN-LAST:event_jmExportarParaExelActionPerformed

    private void btnHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoricoActionPerformed
        if (this.seletorQuerys != null) {
            this.seletorQuerys.setVisible(true);
            String querySelecionada = this.seletorQuerys.getQuerySelecionada();
            if (!querySelecionada.isEmpty()) {
                this.controler.carregarQuery(querySelecionada);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum arquivo de querys encontrado. Verifique!");
        }
    }//GEN-LAST:event_btnHistoricoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        this.salvarQuery();
    }//GEN-LAST:event_btnSalvarActionPerformed

    public void salvarQuery() {
        if (this.getEditorSelecionado() == null) {
            this.exibirMensagen(Enumerated.TipoMsg.ERRO, "Nenhum editor selecionado!", true);
            return;
        }
        if ((this.localQuerys != null) && (!this.localQuerys.isEmpty())) {
            
            String tituloQuery = JOptionPane.showInputDialog(this, "Digite um título para esta Query");
            
            if (tituloQuery == null) {
                JOptionPane.showMessageDialog(this, "Título inválido!");
                return;
            }
            
            for (String chave : querys.keySet()) {
                if (chave.contains(tituloQuery.trim())) {
                    JOptionPane.showMessageDialog(this, "Este título já está sendo usado, ou é inválido!");
                    return;
                }
            }
            
            this.querys.put(tituloQuery, this.getEditorSelecionado().getText());
            this.controler.atualizarArquivoQuerys(this.querys);
            this.seletorQuerys.atualizarQuerys(querys);
            this.seletorQuerys = new SeletorQuerys(this.parente, true, querys);
        } else {
            JOptionPane.showMessageDialog(this, "Não é possível salvar esta query, pois não há um arquivo como destino!", "Falha", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    
    public final void setIconesJtree() {
        JTreeRenderer renderer = new JTreeRenderer();
        renderer.setIcon(Tabela.class, viewUtil.getIcon("icons8-planilha-de-dados-16.png"));
        renderer.setIcon(LinhaTabela.class, viewUtil.getIcon("icons8-planilha-16.png"));
        renderer.setIcon(String.class, viewUtil.getIcon("icons8-banco-de-dados-16.png"));
        jTreeBancoDeDados.setCellRenderer(renderer);
    }

    public void adicionarTab() {

        JPanel cp = new JPanel(new BorderLayout());
        RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_SQL);
        RTextScrollPane sp = new RTextScrollPane(textArea);
        RSyntaxTextArea.setTemplatesEnabled(true);
        Template.adicionarTemplate(textArea);
        cp.add(sp);

        loadKeyStrokes(textArea);

        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        textArea.setCodeFoldingEnabled(true);
        textArea.setAutoIndentEnabled(true);
        textArea.setPaintTabLines(true);
        textArea.setMarkOccurrences(true);

        jtbpQueryEditors.add("Query" + tab, cp);
        jtbpQueryEditors.setTabComponentAt(jtbpQueryEditors.getTabCount() - 1, new ButtonTabComponent(jtbpQueryEditors));
        tab++;
    }

    /**
     * Retorna o editor atual, onde está sendo editado.
     *
     * @return Editor atual.
     */
    public RSyntaxTextArea getEditorSelecionado() {
        if (jtbpQueryEditors.getSelectedIndex() != -1) {
            JPanel painel = (JPanel) jtbpQueryEditors.getSelectedComponent();
            this.getEditor((Container) painel);
            return txtEditor;
        }
        return null;
    }

    /**
     * Inicializa a variável global <b>txtEditor</b> Com o editor de querys.
     *
     * @param container Componente inicial onde está o Editor.
     */
    public void getEditor(Container container) {
        for (Component c : container.getComponents()) {
            if (c instanceof RSyntaxTextArea) {
                txtEditor = (RSyntaxTextArea) c;
                break;
            } else if (c instanceof Container) {
                getEditor((Container) c);
            }
        }
    }

    /**
     * Retorna a tabela de resultados, resposável por exibir os dados da query.
     *
     * @return tabela de resultados.
     */
    public JTable getTabelaResultados() {
        return this.jtbResultados;
    }

    public String getLocalQuerys() {
        return localQuerys;
    }

    public HashMap<String, String> getQuerys() {
        return querys;
    }

    public boolean isPermitirAlteracoes() {
        return permitirAlteracoes;
    }

    public String getSenhaParaAteracoes() {
        return senhaParaAteracoes;
    }

    
    
    /**
     * Exibe uma mensagem na tabela de saídas.
     *
     * @param tipoMsg Tipo da mensagem a ser exibida.
     * @param msg Mensagem a ser exibida.
     * @param requisitarFoco Se a tabela com as mensagens deve ser exibida ou
     * não.
     */
    public final void exibirMensagen(Enumerated.TipoMsg tipoMsg, String msg, boolean requisitarFoco) {
        if (requisitarFoco) {
            this.jtbpResultados.setSelectedIndex(1);
        } else {
            this.jtbpResultados.setSelectedIndex(0);
        }

        this.msgTabelaModel.addRow(new Object[]{tipoMsg.getDescricao(), msg});
        if (msgTabelaModel.getRowCount() > 10) {
            msgTabelaModel.removeRow(0);
        }
    }

    /**
     * Carrega as teclas de atalho para o component.
     *
     * @param component Componente que mapeará as teclas
     */
    private void loadKeyStrokes(JComponent component) {
        component.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, InputEvent.CTRL_DOWN_MASK), "executarQuery");
        component.getActionMap().put("executarQuery", executarQuery);

        component.getInputMap().put(KeyStroke.getKeyStroke("F9"), "executarQuery");
        component.getActionMap().put("executarQuery", executarQuery);
    }

    /**
     * Ação que será executada
     */
    AbstractAction executarQuery = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            controler.executarQuery(conexaoBd);
        }
    };

    public void rendimensionarTabela() {
        for (int i = 0; i < jtbResultados.getColumnCount(); i++) {
            String value = (jtbResultados.getValueAt(0, i) == null ? "" : jtbResultados.getValueAt(0, i).toString());
            Integer largura = value.length() * 15;
            largura = (largura > 300 ? 300 : (largura < 100 ? 100 : largura));
            jtbResultados.getTableHeader().getColumnModel().getColumn(i).setPreferredWidth(largura);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QueryTelaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QueryTelaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QueryTelaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QueryTelaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarTab;
    private javax.swing.JButton btnExecutar;
    private javax.swing.JButton btnHistorico;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTree jTreeBancoDeDados;
    private javax.swing.JMenuItem jmExportarParaExel;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnNavegacao;
    private javax.swing.JPanel jpnQueryEditor;
    private javax.swing.JPanel jpnResult;
    private javax.swing.JPanel jpnSuperior;
    private javax.swing.JPanel jpnTelaPrincipal;
    private javax.swing.JPopupMenu jppmOpcoesTabelaResultados;
    private javax.swing.JTable jtbMensagens;
    private javax.swing.JTable jtbResultados;
    private javax.swing.JTabbedPane jtbpQueryEditors;
    private javax.swing.JTabbedPane jtbpResultados;
    // End of variables declaration//GEN-END:variables

}
