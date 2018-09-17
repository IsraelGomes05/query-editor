package br.org.queryeditor.forms.formsutil;

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public class JTreeRenderer extends DefaultTreeCellRenderer {

    private final Map<Class< ?>, Icon> icons = new HashMap();

    public Icon setIcon(Class< ?> aClass, Icon icon) {
        return icons.put(aClass, icon);
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value,
            boolean sel, boolean expanded, boolean leaf, int row,
            boolean hasFocus) {
        DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) super.getTreeCellRendererComponent(
                tree, value, sel, expanded, leaf, row, hasFocus);

        Icon icon = icons.get(value.getClass());

        if (icon != null) {
            renderer.setIcon(icon);
        }

        return renderer;
    }
}
