package br.org.queryeditor.model;

import java.util.Objects;

/**
 * Função<br>.
 *
 * created 00/00/2018<br>
 * lastModified 00/00/2018
 *
 * @author  Israel Gomes
 * @version 1.0
 * @since   1.0
 */
public class LinhaTabela {

    private String nome;
    private String tipoDeDados;

    public LinhaTabela() {
    }

    public LinhaTabela(String nome, String tipoDeDados) {
        this.nome = nome;
        this.tipoDeDados = tipoDeDados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoDeDados() {
        return tipoDeDados;
    }

    public void setTipoDeDados(String tipoDeDados) {
        this.tipoDeDados = tipoDeDados;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LinhaTabela other = (LinhaTabela) obj;
        return true;
    }

    @Override
    public String toString() {
        return getNome().concat(String.format(" [%s]", this.getTipoDeDados().toLowerCase()));
    }
}
