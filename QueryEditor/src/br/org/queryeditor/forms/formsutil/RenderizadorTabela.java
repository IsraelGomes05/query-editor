package br.org.queryeditor.forms.formsutil;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 * Permite que as linhas de uma tabela, mudem de cor de acordo com a condição
 * estipulada.<br>
 *
 * created 07/07/2018<br>
 * lastModified 07/08/2018
 *
 * @author Israel Gomes
 * @version 1.0
 * @since 3.0.0
 */
public class RenderizadorTabela implements TableCellRenderer {

    public static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        Component renderer = DEFAULT_RENDERER.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, 0);

        Color foreground;

        Object ref = table.getValueAt(row, 0);
        if (ref != null && ref == "Erro") {
            foreground = new Color(188, 66, 45);
        } else if (ref != null && ref == "Info") {
            foreground = new Color(3, 150, 12);
        } else {
            foreground = new Color(45, 102, 188);
        }

        renderer.setForeground(foreground);
        return renderer;
    }
}
