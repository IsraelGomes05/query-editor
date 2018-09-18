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

    private static final char[] hexchars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    
    public static String lerArquivo(File arquivo) throws IOException {
        String linha;
        StringBuilder retorno = new StringBuilder();
        BufferedReader conteudo = new BufferedReader(new FileReader(arquivo));
        while (conteudo.ready()) {
            linha = conteudo.readLine();
            if (linha.contains("]")) {
                retorno.append(linha.replace("]", "]\r\n"));
                continue;
            }
            
            if (linha.isEmpty()) {
                continue;
            }
            retorno.append(linha).append("\r\n");
        }
        return retorno.toString();
    }

    public static void escreverArquivo(String local, String conteudo) throws FileNotFoundException, IOException {
        File file;
        FileWriter fWriter;
        file = new File(local);

        if (file.exists()) {
            fWriter = new FileWriter(file);
            fWriter.write(conteudo);
            fWriter.flush();
            fWriter.close();
        }
    }
    
    public static String byte2hex(byte[] binput) {
        StringBuilder sb = new StringBuilder(binput.length * 2);
        for (int i = 0; i < binput.length; i++) {
            int high = ((binput[i] & 0xF0) >> 4);
            int low = (binput[i] & 0x0F);
            sb.append(hexchars[high]);
            sb.append(hexchars[low]);
        }
        return sb.toString();
    }
}
