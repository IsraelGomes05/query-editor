
package br.org.queryeditor.controler.util;

import java.awt.Component;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 * Permite a expotação dos dados de uma tabela para exel<br>
 * 
 * created      08/09/2018<br>
 * lastModified 08/09/2018
 * 
 * @author      Israel Gomes
 * @version     1.0
 * @since       1.0
 */
public class Exportacao {
    
    public static void exportarParaExel(Component conponent ,JTable tabela) {
        JFileChooser fc = new JFileChooser();
        int option = fc.showSaveDialog(conponent);
        if (option == JFileChooser.APPROVE_OPTION) {
            String filename = fc.getSelectedFile().getName();
            String path = fc.getSelectedFile().getParentFile().getPath();
            int len = filename.length();
            String ext = "";
            String file;
            if (len > 4) {
                ext = filename.substring(len - 4, len);
            }
            if (ext.equals(".xls")) {
                file = path + "\\" + filename;
            } else {
                file = path + "\\" + filename + ".xls";
            }
            try {
                paraExcel(tabela, new File(file));
                JOptionPane.showMessageDialog(null, "<html><font size=\"4\" color=\"green\">Expotação concluída com sucesso!</font></html>", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "<html><font size=\"4\" color=\"red\">Falha ao exportar arquivo</font></html> \n" + ex.getMessage(), "Falha", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void paraExcel(JTable table, File file) throws IOException {
        TableModel modelTemp = table.getModel();
        FileWriter saida = new FileWriter(file);
        saida.write("<html> <head><meta charset=\"utf-8\"></head><style>\n"
                + "th, td {"
                + "    font-size: 12pt;"
                + "}"
                + "</style><table border=\"1\"><tr>");
        for (int i = 0; i < modelTemp.getColumnCount(); i++) {
            saida.write("<th>" + modelTemp.getColumnName(i) + "</th>");
        }
        saida.write("</tr>");
        for (int i = 0; i < modelTemp.getRowCount(); i++) {
            saida.write("<tr>");
            for (int j = 0; j < modelTemp.getColumnCount(); j++) {
                saida.write("<td>" + modelTemp.getValueAt(i, j).toString() + "</td>");
            }
            saida.write("</tr>");
        }
        saida.write("</table></html>");
        saida.close();
    }
}
