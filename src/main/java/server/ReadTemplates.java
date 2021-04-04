package server;

import javax.imageio.IIOException;
import java.io.*;

public class ReadTemplates {


    public String ReadHtml(String html) {
        StringBuilder rez = new StringBuilder();

        try {
            InputStream input = new FileInputStream("src/main/java/" + html);

            BufferedReader br = new BufferedReader(new InputStreamReader(input));

            try {
                String line;
                while ((line = br.readLine()) != null) {
                    rez.append(line).append('\n');
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return rez.toString();
    }
}




