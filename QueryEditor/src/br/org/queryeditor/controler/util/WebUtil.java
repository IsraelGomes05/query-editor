
package br.org.queryeditor.controler.util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Funcion...
 *
 * @author  Israel Gomes
 * @version 1.0
 */
public class WebUtil {

    public static String get(String URL) throws IOException, Exception {
        HttpURLConnection request = (HttpURLConnection) new URL(URL).openConnection();

        try {
            request.setRequestProperty("Content-Type", "html");
            request.setConnectTimeout(20000);
            request.connect();

            int codigo = request.getResponseCode();

            if (codigo != 200) {
               throw new Exception("Falha ao ler querys no DontPad " + request.getResponseMessage() );
            }
            
            return readResponse(request);
        } finally {
            request.disconnect();
        }
    }


    private static  String readResponse(HttpURLConnection request) throws IOException {
        ByteArrayOutputStream os;
        try (InputStream is = request.getInputStream()) {
            os = new ByteArrayOutputStream();
            int b;
            while ((b = is.read()) != -1) {
                os.write(b);
            }
        }
        return new String(os.toByteArray());
    }
}