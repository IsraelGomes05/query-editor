package br.org.queryeditor.model;

import java.util.ArrayList;
import java.util.List;
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
public class Tabela {

    private String nome;
    private List<LinhaTabela> linhaTabela = new ArrayList();

    public Tabela() {
    }

    public Tabela(String nome, ArrayList<LinhaTabela> linhaTabela) {
        this.nome = nome;
        this.linhaTabela = linhaTabela;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<LinhaTabela> getLinhaTabela() {
        return (ArrayList<LinhaTabela>) linhaTabela;
    }

    public void setLinhaTabela(ArrayList<LinhaTabela> linhaTabela) {
        this.linhaTabela = linhaTabela;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nome);
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
        final Tabela other = (Tabela) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNome();
    }

}
