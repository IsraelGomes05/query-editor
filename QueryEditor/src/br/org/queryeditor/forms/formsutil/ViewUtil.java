/**
 * @created  17/06/2018
 * @lastModified 17/06/2018
 */
package br.org.queryeditor.forms.formsutil;

import br.org.queryeditor.controler.util.Enumerated;
import br.org.queryeditor.forms.QueryTelaPrincipal;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Funcion...
 *
 * @author  Israel Gomes
 * @version 1.0
 * @since   1.0
 */
public class ViewUtil {

    private static final QueryTelaPrincipal view;

    static {
        view = new QueryTelaPrincipal();
    }
    
    public void alterarIcone(JLabel label, String imagem) {
        String diretorio = "/br/org/queryeditor/imagens/" + imagem;
        try {

            URL resource = getClass().getResource(diretorio);
            ImageIcon img = new ImageIcon(resource);

            label.setIcon(img);

        } catch (Exception ex) {
            view.exibirMensagen(Enumerated.TipoMsg.ERRO, ex.getMessage(), true);
        }
    }

    public void alterarIcone(JButton botao, String imagem) {
        String diretorio = "/br/org/queryeditor/imagens/" + imagem;
        try {

            URL resource = getClass().getResource(diretorio);
            ImageIcon img = new ImageIcon(resource);

            botao.setIcon(img);

        } catch (Exception ex) {
            view.exibirMensagen(Enumerated.TipoMsg.ERRO, ex.getMessage(), true);
        }
    }
    
    public ImageIcon getImageIcon(String imagem) {
        String diretorio = "/br/org/queryeditor/imagens/" + imagem;
        try {
            URL resource = getClass().getResource(diretorio);
            ImageIcon img = new ImageIcon(resource);

            return img;
        } catch (Exception ex) {
            view.exibirMensagen(Enumerated.TipoMsg.ERRO, ex.getMessage(), true);
            return null;
        }
    }
    
    public Icon getIcon(String imagem) {
        String diretorio = "/br/org/queryeditor/imagens/" + imagem;
        try {
            URL resource = getClass().getResource(diretorio);
            ImageIcon img = new ImageIcon(resource);

            return img;
        } catch (Exception ex) {
            view.exibirMensagen(Enumerated.TipoMsg.ERRO, ex.getMessage(), true);
            return null;
        }
    }
}
