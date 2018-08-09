
package br.org.queryeditor.controler.util;

/**
 * Definir os Enums utilitários.<br>
 * 
 * created      07/08/2018<br>
 * lastModified 08/08/2018
 * 
 * @author      Israel Gomes
 * @version     1.0
 * @since       1.0 
 */
public class Enumerated {

    public enum TipoMsg {
        INFO(1,"Info"),
        ERRO(2,"Erro"),
        AVISO(3,"Aviso");
        
        int id;
        String descricao;

        private TipoMsg(int id, String descricao) {
            this.id = id;
            this.descricao = descricao;
        }

        public int getId() {
            return id;
        }

        public String getDescricao() {
            return descricao;
        }

        @Override
        public String toString() {
            return this.getDescricao();
        }
    }
}
