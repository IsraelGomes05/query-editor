
package br.org.queryeditor.model;

import java.util.ArrayList;

/**
 * Define o Bean, que representa o resultado de uma consulta no banco de dados.<br>
 * 
 * created      05/08/2018<br>
 * lastModified 05/08/2018
 * 
 * @author      Israel Gomes
 * @version     1.0
 * @since       1.0
 */
public class Info {
    
    private Integer index;
    private String  nomeColuna;
    private String  tipoDadoColuna;
    private ArrayList dados;

    public Info() {
        this.dados = new ArrayList();
    }

    public Info(Integer index, String nomeColuna, String tipoColuna) {
        this.index = index;
        this.nomeColuna = nomeColuna;
        this.tipoDadoColuna = tipoColuna;
        this.dados = new ArrayList();
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getNomeColuna() {
        return nomeColuna;
    }

    public void setNomeColuna(String nomeColuna) {
        this.nomeColuna = nomeColuna;
    }

    public String getTipoDadoColuna() {
        return tipoDadoColuna;
    }

    public void setTipoDadoColuna(String tipoColuna) {
        this.tipoDadoColuna = tipoColuna;
    }

    public ArrayList getDados() {
        return dados;
    }

    public void setDados(Object dado) {
        this.dados.add(dado);
    }
}
