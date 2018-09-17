package br.org.queryeditor.controler.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Função<br>.
 *
 * created 00/00/2018<br>
 * lastModified 00/00/2018
 *
 * @author Israel Gomes
 * @version 1.0
 * @since 1.0
 */
public class StringUtils {

    public static String lerArquivo(File arquivo) throws IOException {
        String verificacao;
        StringBuilder retorno = new StringBuilder();
        BufferedReader conteudo = new BufferedReader(new FileReader(arquivo));
        while (conteudo.ready()) {
            verificacao = conteudo.readLine();
            if (verificacao.contains("]")) {
                retorno.append(verificacao.replace("]", "\r\n")).append("]");
                continue;
            }
            retorno.append(verificacao).append("\r\n");
        }
        return retorno.toString();
    }

    public static void escreverArquivo(String local, String nomeArquivo, String conteudo) throws FileNotFoundException, IOException {
        File file;
        FileWriter fWriter;
        String diretorio = local + nomeArquivo;
        file = new File(diretorio + ".txt");

        if (file.exists()) {
            fWriter = new FileWriter(file);
            fWriter.write(conteudo);
            fWriter.flush();
            fWriter.close();
        }
    }
}
