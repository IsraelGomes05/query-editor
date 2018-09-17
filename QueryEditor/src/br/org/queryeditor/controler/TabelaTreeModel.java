package br.org.queryeditor.controler;


import br.org.queryeditor.model.LinhaTabela;
import br.org.queryeditor.model.Tabela;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 * Função<br>
 *
 * created 16/09/2018<br>
 * lastModified 16/09/2018
 *
 * @author Israel Gomes
 * @version 1.0
 * @since 1.0
 */
public class TabelaTreeModel implements TreeModel {

    private final String raiz;
    private final List<TreeModelListener> listeners = new ArrayList();

    private final List<Tabela> tabelas;

    public TabelaTreeModel(List<Tabela> tabelas, String raiz) {
        this.tabelas = tabelas;
        this.raiz = raiz;
    }

    
    @Override
    public Object getChild(Object parent, int index) {
        if (parent == raiz)
        {
            return tabelas.get(index); 
        }
        if (parent instanceof Tabela) 
        {
            return ((Tabela) parent).getLinhaTabela().get(index);
        }
        throw new IllegalArgumentException("Invalid parent class"
                + parent.getClass().getSimpleName());
    }

    @Override
    public int getChildCount(Object parent) {
        if (parent == raiz) {
            return tabelas.size();
        }
        if (parent instanceof Tabela)
        {
            return ((Tabela) parent).getLinhaTabela().size();
        }
        throw new IllegalArgumentException("Invalid parent class"
                + parent.getClass().getSimpleName());
    }
    
    @Override
    public int getIndexOfChild(Object parent, Object child) {
        if (parent == raiz) {
            return tabelas.indexOf(child);
        }
        if (parent instanceof Tabela) {
            return ((Tabela) parent).getLinhaTabela().indexOf(child);
        }
        return 0;
    }
    
    @Override
    public Object getRoot() {
        return raiz;
    }

    @Override
    public boolean isLeaf(Object node) {
        return node instanceof LinhaTabela;
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        // Com esse método, a tree avisa que um objeto mudou.
        // Editem se quiserem que um nó seja editável
    }
    // Esses dois métodos abaixo poderiam ir para classe abstrata

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        listeners.remove(l);
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
        listeners.add(l);
    }
}
