
package br.org.queryeditor.controler;

import org.fife.ui.rsyntaxtextarea.CodeTemplateManager;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.templates.CodeTemplate;
import org.fife.ui.rsyntaxtextarea.templates.StaticCodeTemplate;

/**
 * Função<br>.
 * 
 * created      05/08/2018<br>
 * lastModified 05/08/2018
 * 
 * @author      Israel Gomes
 * @version     1.0
 * @since       1.0
 */
public class Template {
    
    
    public static void adicionarTemplate(RSyntaxTextArea editor) {
        CodeTemplateManager ctm = RSyntaxTextArea.getCodeTemplateManager();
        CodeTemplate ct = new StaticCodeTemplate("s", "SELECT", null);
        ctm.addTemplate(ct);

        ct = new StaticCodeTemplate("d", "DELETE", null);
        ctm.addTemplate(ct);
    }
    
}
