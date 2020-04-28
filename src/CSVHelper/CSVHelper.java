package CSVHelper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {
    public static void main(String[] args) {
        String in = "C://Users/zhang/Desktop/1.csv";
//        String out = "C://Users/zhang/Desktop/2.csv";
        String out = "C://Users/zhang/Desktop/2.txt";
        try {
            createFile(read(in), out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void change(List<String> result, String line) {
//        String[] s=line.split(",");
//        System.out.println("insert into town(county_code,town_code,town_name,town_level) values('" +
//                s[0].substring(0, 6) + "','" + s[0].substring(0,9) + "','" + s[1] + "',5);");
//        String sql="insert into town(county_code,town_code,town_name,town_level) values('" +
//                s[0].substring(0, 6) + "','" + s[0].substring(0,9) + "','" + s[1] + "',5);";
//        result.add(sql);
        System.out.println(line);
    }
//
    public static List<String> read(String fieldPath) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fieldPath),"GBK"));
        List<String> result = new ArrayList<>();
//        String line;
//        while ((line = reader.readLine()) != null) {
//            change(result, line);
//        }
//        reader.close();
//        System.out.println("--------------------读取成功--------------------");
        return result;
    }

    public static void createFile(List<String> list, String outPath) throws Exception {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outPath),"UTF-8"));
        for (int i = 0; i < list.size(); i++) {
            out.write(list.get(i));
            out.newLine();
        }
        out.flush();
        out.close();
        System.out.println("--------------------写入成功--------------------");
    }
}

