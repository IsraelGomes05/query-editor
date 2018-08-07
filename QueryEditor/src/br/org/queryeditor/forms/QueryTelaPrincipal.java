package br.org.queryeditor.forms;

import br.org.queryeditor.controler.Controler;
import br.org.queryeditor.controler.Template;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.sql.Connection;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

/**
 * Tela principal da aplicação<br>
 *
 * created 05/08/2018<br>
 * lastModified 05/08/2018
 *
 * @author Israel Gomes
 * @version 1.0
 * @since 1.0
 */
public class QueryTelaPrincipal extends javax.swing.JDialog {

    private int tabs = 1;
    private static Connection con;
    private final Controler controler;
    private RSyntaxTextArea txtEditor;
    private DefaultTableModel msgTabelaModel;
    
    
    /**
     * Cria e exibe a tela principal.
     *
     * @param parent Tela a qual esta herdará as propriedades.
     * @param modal Se a tela que chamou esta, poderá ser acessada ou não com
     * esta em execução.
     * @param conexao Conexão com o banco de dados.
     */
    public QueryTelaPrincipal(java.awt.Frame parent, boolean modal, Connection conexao) {
        super(parent, modal);
        initComponents();
        this.setTitle(parent.getTitle() + " SQL Editor");
        con = conexao;
        this.controler = new Controler(this);
        this.msgTabelaModel = (DefaultTableModel) this.jtbMensagens.getModel();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnTelaPrincipal = new javax.swing.JPanel();
        jpnMenu = new javax.swing.JPanel();
        btnAdicionarTab = new javax.swing.JButton();
        btnExecutar = new javax.swing.JButton();
        jSplitPane2 = new javax.swing.JSplitPane();
        jpnQueryEditor = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jpnSuperior = new javax.swing.JPanel();
        jpnNavegacao = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jtbpQueryEditors = new javax.swing.JTabbedPane();
        jpnResult = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jtbpResultados = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbResultados = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtbMensagens = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jpnMenu.setBackground(new java.awt.Color(44, 62, 80));
        jpnMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        btnAdicionarTab.setText("Novo Editor");
        btnAdicionarTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarTabActionPerformed(evt);
            }
        });

        btnExecutar.setText("Executar");
        btnExecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExecutarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdicionarTab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExecutar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarTab)
                    .addComponent(btnExecutar))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jSplitPane2.setDividerLocation(350);
        jSplitPane2.setDividerSize(4);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 343, Short.MAX_VALUE)
        );

        jScrollPane5.setViewportView(jPanel2);

        javax.swing.GroupLayout jpnNavegacaoLayout = new javax.swing.GroupLayout(jpnNavegacao);
        jpnNavegacao.setLayout(jpnNavegacaoLayout);
        jpnNavegacaoLayout.setHorizontalGroup(
            jpnNavegacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
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
                .addGap(0, 0, 0)
                .addComponent(jtbpQueryEditors, javax.swing.GroupLayout.DEFAULT_SIZE, 1074, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jpnSuperiorLayout.setVerticalGroup(
            jpnSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnNavegacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jtbpQueryEditors)
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jSplitPane2.setTopComponent(jpnQueryEditor);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setToolTipText("");

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        jtbResultados.setAutoCreateRowSorter(true);
        jtbResultados.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jtbResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtbResultados.setShowHorizontalLines(false);
        jtbResultados.setShowVerticalLines(false);
        jScrollPane3.setViewportView(jtbResultados);

        jtbpResultados.addTab("Resultados", jScrollPane3);

        jtbMensagens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "INFO", "SAÍDA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
            .addComponent(jtbpResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 1205, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbpResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
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
            .addComponent(jScrollPane2)
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

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

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
        this.controler.executarQuery(QueryTelaPrincipal.con);
    }//GEN-LAST:event_btnExecutarActionPerformed

    public void adicionarTab() {
        JPanel cp = new JPanel(new BorderLayout());

        RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_SQL);
        RTextScrollPane sp = new RTextScrollPane(textArea);
        RSyntaxTextArea.setTemplatesEnabled(true);
        Template.adicionarTemplate(textArea);

        cp.add(sp);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        textArea.setCodeFoldingEnabled(true);
        textArea.setAutoIndentEnabled(true);
        textArea.setPaintTabLines(true);
        textArea.setMarkOccurrences(true);

        jtbpQueryEditors.add("Query" + this.tabs++, cp);
    }

    public RSyntaxTextArea getEditorSelecionado() {
        if (jtbpQueryEditors.getSelectedIndex()!= -1) {
            JPanel painel = (JPanel) jtbpQueryEditors.getSelectedComponent();
            this.getEditor((Container) painel);
            return txtEditor;
        }
        return null;
    }

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

    public JTable getTabelaResultados() {
        return this.jtbResultados;
    }

    public void exibirMensagen(String info, String msg) {
        this.msgTabelaModel.addRow(new Object[]{info, msg});
        this.jtbpResultados.setSelectedIndex(1);
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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnNavegacao;
    private javax.swing.JPanel jpnQueryEditor;
    private javax.swing.JPanel jpnResult;
    private javax.swing.JPanel jpnSuperior;
    private javax.swing.JPanel jpnTelaPrincipal;
    private javax.swing.JTable jtbMensagens;
    private javax.swing.JTable jtbResultados;
    private javax.swing.JTabbedPane jtbpQueryEditors;
    private javax.swing.JTabbedPane jtbpResultados;
    // End of variables declaration//GEN-END:variables

}
