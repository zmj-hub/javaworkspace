package IsolationTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
         double[] testData={1.0,8.0,3.0,2.0,5.0,4.0,7.0,999.0,9.0};
        List<Map<String,Object>> data = new ArrayList<>();
        Map<String, Object> data1 = new HashMap<>();
        Map<String, Object> data2 = new HashMap<>();
        Map<String, Object> data3 = new HashMap<>();
        Map<String, Object> data4 = new HashMap<>();
        Map<String, Object> data5 = new HashMap<>();
        Map<String, Object> data6 = new HashMap<>();
        Map<String, Object> data7 = new HashMap<>();
        Map<String, Object> data8 = new HashMap<>();
        Map<String, Object> data9 = new HashMap<>();
        Map<String, Object> data10 = new HashMap<>();
        data1.put("a", 99);
        data2.put("a",99);
        data3.put("a", 0);
        data4.put("a", 0);
        data5.put("a", 0);
        data6.put("a", 53);
        data7.put("a", 15);
        data8.put("a", 12);
        data9.put("a", 20);
        data10.put("a", 3);
        data.add(data1);
        data.add(data2);
        data.add(data3);
        data.add(data4);
        data.add(data5);
        data.add(data6);
        data.add(data7);
        data.add(data8);
        data.add(data9);
        data.add(data10);
//        for (int i = 0; i <10 ; i++) {
//            Map<String, Object> data1 = new HashMap<>();
//            data1.put("a", (int)(Math.random()*100));
//            data.add(data1);
//        }
        IsolationTreeTool isolationTreeTool = new IsolationTreeTool("a");
        System.out.println(data);
        List<List<Map<String, Object>>> result = isolationTreeTool.timeSeriesAnalyse(data);
        System.out.println(result.toString());
//        System.out.println(result.size());
//        DisplayTool.showResult(isolationTreeTool);
    }
}
