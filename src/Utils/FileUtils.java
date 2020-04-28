package Utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileUtils {
    public static String readFile() throws Exception {
        String src = "C://Users/zhang/Desktop/11111.txt";
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(src), "UTF-8"));
        StringBuilder ss = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            ss.append(line);
        }
        reader.close();
        return ss.toString();
    }
}
